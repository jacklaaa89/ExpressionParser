package org.expression.computation.decomposition;

import org.expression.Scalar;
import static org.expression.computation.linear.AbstractSolver.EPS_SCALAR;
import org.expression.structure.Matrix;
import org.expression.structure.Vector;

/**
 * Singular Value Decomposition.
 * <p>
 * For an m-by-n matrix A with {@code m >= n}, the singular value decomposition is
 * an m-by-n orthogonal matrix U, an n-by-n diagonal matrix D, and an n-by-n
 * orthogonal matrix V so that A = U*D*V.
 * @author Jack Timblin
 */
public class SingleValueDecomposition extends AbstractDecompositor implements Decompositor {
    
    private Matrix U;
    private Matrix V;
    private Matrix D;
    
    public SingleValueDecomposition(Matrix A) {
        super(A);
    }
    
    @Override
    public void decompose() {
        Matrix a = A.copy();
        int n = Math.min(a.getRowSize(), a.getColumnSize());
        Matrix u = Matrix.zeroes(a.getRowSize(), n);
        Matrix s = Matrix.zeroes(a.getColumnSize(), a.getRowSize());
        Matrix v = Matrix.zeroes(a.getColumnSize(), a.getRowSize());
        Vector e = Vector.zeroes(a.getColumnSize());
        Vector w = Vector.zeroes(a.getRowSize());
        int nc = Math.min(a.getRowSize() - 1, a.getColumnSize());
        int nr = Math.max(0, Math.min(a.getColumnSize() - 2, a.getRowSize()));
        for(int k = 0; k < Math.max(nc, nr); k++) {
            if(k < nc) {
                s.set(k, k, Scalar.ZERO);
                for(int i = k; i < a.getRowSize(); i++) {
                    s.set(k, k, Scalar.hypot(s.get(k, k), a.get(i, k)));
                }
                if(s.get(k, k).compareTo(EPS_SCALAR) == 1) {
                    if(a.get(k, k).compareTo(Scalar.ZERO) == -1) {
                        Scalar se = s.get(k, k).negate();
                        s.set(k, k, se);
                    }
                    Scalar skk = s.get(k, k);
                    for(int i = k; i < a.getRowSize(); i++) {
                        Scalar se = a.get(i, k).divide(skk);
                        a.set(i, k, se);
                    }
                    Scalar ik = a.get(k, k).add(Scalar.ONE);
                    a.set(k, k, ik);
                }
                Scalar is = s.get(k, k).negate();
                s.set(k, k, is);
            }
            for(int j = k + 1; j < a.getColumnSize(); j++) {
                if((k < nc) & (s.get(k, k).abs().compareTo(EPS_SCALAR) == 1)) {
                    Scalar t = Scalar.ZERO;
                    for(int i = k; i < a.getRowSize(); i++) {
                        Scalar d = a.get(i, k).multiply(a.get(i, j));
                        t = t.add(d);
                    }
                    t = (Scalar) t.negate().divide(a.get(k, k));
                    for(int i = k; i < a.getRowSize(); i++) {
                        Scalar d = t.multiply(a.get(i, k));
                        a.set(i, j, a.get(i, j).add(d));
                    }
                }
                e.set(j, a.get(k, j));
            }
            if(k < nc) {
                for(int i = k; i < a.getRowSize(); i++) {
                    u.set(i, k, a.get(i, k));
                }
            }
            if(k < nr) {
                e.set(k, Scalar.ZERO);
                for(int i = k + 1; i < a.getColumnSize(); i++) {
                    e.set(k, Scalar.hypot(e.get(k), e.get(i)));
                }
                if(e.get(k).abs().compareTo(EPS_SCALAR) == 1) {
                    if(e.get(k + 1).compareTo(Scalar.ZERO) == -1) {
                        Scalar d = e.get(k).negate();
                        e.set(k, d);
                    }
                    Scalar ek = e.get(k);
                    for(int i = k + 1; i < a.getColumnSize(); i++) {
                        e.set(i, e.get(i).divide(ek));
                    }
                    e.set(k + 1, e.get(k + 1).add(Scalar.ONE));
                }
                e.set(k, e.get(k).negate());
                if((k + 1 < a.getRowSize()) && (e.get(k).abs().compareTo(EPS_SCALAR) == 1)) {
                    for(int i = k + 1; i < a.getRowSize(); i++) {
                        w.set(i, Scalar.ZERO);
                    }
                    for(int j = k + 1; j < a.getColumnSize(); j++) {
                        for(int i = k + 1; i < a.getRowSize(); i++) {
                            Scalar d = e.get(j).multiply(a.get(i, j));
                            w.set(i, w.get(i).add(d));
                        }
                    }
                    for(int j = k + 1; j < a.getColumnSize(); j++) {
                        Scalar t = e.get(j).negate().divide(e.get(k + 1));
                        for(int i = k + 1; i < a.getRowSize(); i++) {
                            Scalar d = t.multiply(w.get(i));
                            a.set(i, j, a.get(i, j).add(d));
                        }
                    }
                }
                for(int i = k + 1; i < a.getColumnSize(); i++) {
                    v.set(i, k, e.get(i));
                }
            }
        }
        int p = Math.min(a.getColumnSize(), a.getRowSize() + 1);
        if(nc < a.getColumnSize()) {
            s.set(nc, nc, a.get(nc, nc));
        }
        if(a.getRowSize() < p) {
            s.set(p - 1, p - 1, Scalar.ZERO);
        }
        if(nr + 1 < p) {
            e.set(nr, a.get(nr, p - 1));
        }
        e.set(p - 1, Scalar.ZERO);
        for(int j = nc; j < n; j++) {
            for(int i = 0; i < a.getRowSize(); i++) {
                u.set(i, j, Scalar.ZERO);
            }
            u.set(j, j, Scalar.ONE);
        }
        for(int k = nc - 1; k >= 0; k--) {
            if(s.get(k, k).abs().compareTo(EPS_SCALAR) == 1) {
                for(int j = k + 1; j < n; j++) {
                    Scalar t = Scalar.ZERO;
                    for(int i = k; i < a.getRowSize(); i++) {
                        Scalar d = u.get(i, k).multiply(u.get(i, j));
                        t = t.add(d);
                    }
                    t = t.negate().divide(u.get(k, k));
                    for(int i = k; i < a.getRowSize(); i++) {
                        Scalar d = t.multiply(u.get(i, k));
                        u.set(i, j, u.get(i, j).add(d));
                    }
                }
                for(int i = k; i < a.getRowSize(); i++) {
                    u.set(i, k, u.get(i, k).negate());
                }
                u.set(k, k, u.get(k, k).add(Scalar.ONE));
                for(int i = 0; i < k - 1; i++) {
                    u.set(i, k, Scalar.ZERO);
                }
            } else {
                for(int i = 0; i < a.getRowSize(); i++) {
                    u.set(i, k, Scalar.ZERO);
                }
                u.set(k, k, Scalar.ONE);
            }
        }
        for(int k = n - 1; k >= 0; k--) {
            if((k < nr) & (e.get(k).abs().compareTo(EPS_SCALAR) == 1)) {
                for(int j = k + 1; j < n; j++) {
                    Scalar t = Scalar.ZERO;
                    for(int i = k + 1; i < a.getColumnSize(); i++) {
                        Scalar d = v.get(i, k).multiply(v.get(i, j));
                        t = t.add(d);
                    }
                    t = t.negate().divide(v.get(k + 1, k));
                    for(int i = k + 1; i < a.getColumnSize(); i++) {
                        Scalar d = t.multiply(v.get(i, k));
                        v.set(i, j, v.get(i, j).add(d));
                    }
                }
            }
            for(int i = 0; i < a.getColumnSize(); i++) {
                v.set(i, k, Scalar.ZERO);
            }
            v.set(k, k, Scalar.ONE);
        }
        int pp = p - 1;
        int iter = 0;
        double eps = Math.pow(2.0, -52.0);
        double tiny = Math.pow(2.0, -966.0);
        while(p > 0) {
            int k, kase;
            for(k = p - 2; k >= -1; k--) {
                if(k == -1) {
                    break;
                }
                double ve = Math.abs(e.get(k).doubleValue());
                double vk = Math.abs(s.get(k, k).doubleValue());
                double vk1 = Math.abs(s.get(k + 1, k + 1).doubleValue());
                if(ve <= tiny + eps * (vk) + vk1) {
                    e.set(k, Scalar.ZERO);
                    break;
                }
            }
            if(k == p - 2) {
                kase = 4;
            } else {
                int ks;
                for(ks = p - 1; ks >= k; ks--) {
                    if(ks == k) {
                        break;
                    }
                    Scalar t = (ks != p ? e.get(ks).abs() : Scalar.ZERO)
                            .add((ks != k + 1 ? e.get(ks - 1).abs() : Scalar.ZERO));
                    double vks = Math.abs(s.get(ks, ks).doubleValue());
                    if(vks <= tiny + eps * t.doubleValue()) {
                        s.set(ks, ks, Scalar.ZERO);
                        break;
                    }
                }
                if(ks == k) {
                    kase = 3;
                } else if(ks == p - 1) {
                    kase = 1;
                } else {
                    kase = 2;
                    k = ks;
                }
            }
            k++;
            switch(kase) {
                case 1: {
                    Scalar f = e.get(p - 2);
                    e.set(p - 2, Scalar.ZERO);
                    for(int j = p - 2; j >= k; j--) {
                        Scalar t = Scalar.hypot(s.get(j, j), f);
                        Scalar cs = s.get(j, j).divide(t);
                        Scalar sn = f.divide(t);
                        s.set(j, j, t);
                        if(j != k) {
                            f = sn.negate().multiply(e.get(j - 1));
                            e.set(j - 1, cs.multiply(e.get(j - 1)));
                        }
                        for(int i = 0; i < a.getColumnSize(); i++) {
                            Scalar l = cs.multiply(v.get(i, j));
                            Scalar r = sn.multiply(v.get(i, p - 1));
                            t = l.add(r);
                            Scalar vl = sn.negate().multiply(v.get(i, j));
                            Scalar vr = cs.multiply(v.get(i, p - 1));
                            v.set(i , p - 1, vl.add(vr));
                            v.set(i, j, t);
                        }
                    }
                }
                    break;
                case 2: {
                    Scalar f = e.get(k - 1);
                    e.set(k - 1, Scalar.ZERO);
                    for(int j = k; j < p; j++) {
                        Scalar t = Scalar.hypot(s.get(j, j), f);
                        Scalar cs = s.get(j, j).divide(t);
                        Scalar sn = f.divide(t);
                        s.set(j, j, t);
                        f = sn.negate().multiply(e.get(j));
                        e.set(j, cs.multiply(e.get(j)));
                        for(int i = 0; i < a.getRowSize(); i++) {
                            Scalar l = cs.multiply(u.get(i, j));
                            Scalar r = sn.multiply(u.get(i, k - 1));
                            t = l.add(r);
                            Scalar ul = sn.negate().multiply(u.get(i, j));
                            Scalar ur = cs.multiply(u.get(i, k - 1));
                            u.set(i, k - 1, ul.add(ur));
                            u.set(i, j, t);
                        }
                    }
                }
                    break;
                case 3: {
                    double pm1 = Math.abs(s.get(p - 1, p - 1).doubleValue());
                    double pm2 = Math.abs(s.get(p - 2, p - 2).doubleValue());
                    double epm2 = Math.abs(e.get(p - 2).doubleValue());
                    double skk = Math.abs(s.get(k, k).doubleValue());
                    double ek = Math.abs(e.get(k).doubleValue());
                    Scalar scale = new Scalar(Math.max(Math.max(Math.max(Math.max(pm1, pm2),epm2),skk), ek));
                    Scalar sp = s.get(p - 1, p - 1).divide(scale);
                    Scalar spm1 = s.get(p - 2, p - 2).divide(scale);
                    Scalar epm1 = e.get(p - 2).divide(scale);
                    Scalar sk = s.get(k, k).divide(scale);
                    Scalar ekk = e.get(k).divide(scale);
                    Scalar lb = spm1.add(sp); Scalar rb = spm1.subtract(sp);
                    Scalar rrb = epm1.multiply(epm1); Scalar llb = lb.multiply(rb);
                    Scalar b = llb.add(rrb).divide(Scalar.TWO);
                    Scalar c = sp.multiply(epm1).multiply((sp.multiply(epm1)));
                    Scalar shift = Scalar.ZERO;
                    if((!b.equals(Scalar.ZERO)) | (!c.equals(Scalar.ZERO))) {
                        shift = new Scalar(Math.sqrt((b.multiply(b).add(c)).doubleValue()));
                        if(b.compareTo(Scalar.ZERO) == -1) {
                            shift = shift.negate();
                        }
                        shift = c.divide(b.add(shift));
                    }
                    Scalar f = (sk.add(sp).multiply(sk.subtract(sp))).add(shift);
                    Scalar g = sk.multiply(ekk);
                    for(int j = k; j < p - 1; j++) {
                        Scalar t = Scalar.hypot(f, g);
                        Scalar cs = f.divide(t);
                        Scalar sn = g.divide(t);
                        if(j != k) {
                            e.set(j - 1, t);
                        }
                        f = cs.multiply(s.get(j, j)).add(sn.multiply(e.get(j)));
                        e.set(j, cs.multiply(e.get(j)).subtract(sn.multiply(s.get(j, j))));
                        g = sn.multiply(s.get(j + 1, j + 1));
                        s.set(j + 1, j + 1, cs.multiply(s.get(j + 1, j + 1)));
                        for(int i = 0; i < a.getColumnSize(); i++) {
                            t = cs.multiply(v.get(i, j)).add(sn.multiply(v.get(i, j + 1)));
                            v.set(i, j + 1, sn.negate().multiply(v.get(i, j)).add(cs.multiply(v.get(i, j + 1))));
                            v.set(i, j, t);
                        }
                        t = Scalar.hypot(f, g);
                        cs = f.divide(t);
                        sn = g.divide(t);
                        s.set(j, j, t);
                        f = cs.multiply(e.get(j)).add(sn.multiply(s.get(j + 1, j + 1)));
                        s.set(j + 1, j + 1, sn.negate().multiply(e.get(j)).add(cs.multiply(s.get(j + 1, j + 1))));
                        g = sn.multiply(e.get(j + 1));
                        e.set(j + 1, e.get(j + 1).multiply(cs));
                        if(j < a.getRowSize() - 1) {
                            for(int i = 0; i < a.getRowSize(); i++) {
                                t =  cs.multiply(u.get(i, j)).add(sn.multiply(u.get(i, j + 1)));
                                u.set(i, j + 1, sn.negate().multiply(u.get(i, j)).add(cs.multiply(u.get(i, j + 1))));
                                u.set(i, j, t);
                            }
                        }
                    }
                    e.set(p - 2, f);
                    iter = iter + 1;
                }   
                    break;
                case 4 : {
                    double skk = s.get(k, k).doubleValue();
                    if(skk <= 0.0) {
                        s.set(k, k, skk < 0.0 ? s.get(k, k).negate() : Scalar.ZERO);
                        for(int i = 0; i <= pp; i++) {
                            v.set(i, k, v.get(i, k).negate());
                        }
                    }
                    while(k < pp) {
                        double skk2 = s.get(k, k).doubleValue();
                        double sk1k1 = s.get(k + 1, k + 1).doubleValue();
                        if(skk2 >= sk1k1) {
                            break;
                        }
                        Scalar t = s.get(k, k);
                        s.set(k, k, s.get(k + 1, k + 1));
                        s.set(k + 1, k + 1, t);
                        if(k < a.getColumnSize() - 1) {
                            for(int i = 0; i < a.getColumnSize(); i++) {
                                t = v.get(i, k + 1);
                                v.set(i, k + 1, v.get(i, k));
                                v.set(i, k, t);
                            }
                        }
                        if(k < a.getRowSize() - 1) {
                            for(int i = 0; i < a.getRowSize(); i++) {
                                t = u.get(i, k + 1);
                                u.set(i, k + 1, u.get(i, k));
                                u.set(i, k, t);
                            }
                        }
                        k++;
                    }
                    iter = 0;
                    p--;
                }
                    break;
            }
        }
        this.U = u; this.D = s; this.V = v;
    }
    
    /**
     * return the left singular values.
     * @return U
     */
    public Matrix getU() {
        return this.U;
    }
    
    /**
     * return the right singular values.
     * @return V
     */
    public Matrix getV() {
        return this.V;
    }
    
    /**
     * return the diagonal matrix of singular values.
     * @return D
     */
    public Matrix getD() {
        return this.D;
    }
    
}
