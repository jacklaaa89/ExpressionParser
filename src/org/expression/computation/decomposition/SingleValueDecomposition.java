package org.expression.computation.decomposition;

import org.expression.Scalar;
import org.expression.Type;
import static org.expression.computation.linear.AbstractSolver.EPS_SCALAR;
import org.expression.structure.Matrix;
import org.expression.structure.Vector;

/**
 * Singular Value Decomposition.
 * <p>
 * For an m-by-n matrix A with m >= n, the singular value decomposition is
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
                    s.set(k, k, hypot(s.get(k, k), a.get(i, k)));
                }
                if(s.get(k, k).compareTo((Type)EPS_SCALAR) == 1) {
                    if(a.get(k, k).compareTo((Type)Scalar.ZERO) == -1) {
                        Scalar se = (Scalar) s.get(k, k).neg();
                        s.set(k, k, se);
                    }
                    Scalar skk = s.get(k, k);
                    for(int i = k; i < a.getRowSize(); i++) {
                        Scalar se = (Scalar) a.get(i, k).div(skk);
                        a.set(i, k, se);
                    }
                    Scalar ik = (Scalar) a.get(k, k).plus(Scalar.ONE);
                    a.set(k, k, ik);
                }
                Scalar is = (Scalar) s.get(k, k).neg();
                s.set(k, k, is);
            }
            for(int j = k + 1; j < a.getColumnSize(); j++) {
                if((k < nc) & (s.get(k, k).absolute().compareTo((Type)EPS_SCALAR) == 1)) {
                    Scalar t = Scalar.ZERO;
                    for(int i = k; i < a.getRowSize(); i++) {
                        Scalar d = (Scalar) a.get(i, k).mult(a.get(i, j));
                        t = (Scalar) t.plus(d);
                    }
                    t = (Scalar) t.neg().div(a.get(k, k));
                    for(int i = k; i < a.getRowSize(); i++) {
                        Scalar d = (Scalar) t.mult(a.get(i, k));
                        a.set(i, j, (Scalar) a.get(i, j).plus(d));
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
                    e.set(k, hypot(e.get(k), e.get(i)));
                }
                if(e.get(k).absolute().compareTo((Type)EPS_SCALAR) == 1) {
                    if(e.get(k + 1).compareTo((Type)Scalar.ZERO) == -1) {
                        Scalar d = (Scalar) e.get(k).neg();
                        e.set(k, d);
                    }
                    Scalar ek = e.get(k);
                    for(int i = k + 1; i < a.getColumnSize(); i++) {
                        e.set(i, (Scalar) e.get(i).div(ek));
                    }
                    e.set(k + 1, (Scalar) e.get(k + 1).plus(Scalar.ONE));
                }
                e.set(k, (Scalar) e.get(k).neg());
                if((k + 1 < a.getRowSize()) && (e.get(k).absolute().compareTo((Type)EPS_SCALAR) == 1)) {
                    for(int i = k + 1; i < a.getRowSize(); i++) {
                        w.set(i, Scalar.ZERO);
                    }
                    for(int j = k + 1; j < a.getColumnSize(); j++) {
                        for(int i = k + 1; i < a.getRowSize(); i++) {
                            Scalar d = (Scalar) e.get(j).mult(a.get(i, j));
                            w.set(i, (Scalar) w.get(i).plus(d));
                        }
                    }
                    for(int j = k + 1; j < a.getColumnSize(); j++) {
                        Scalar t = (Scalar) e.get(j).neg().div(e.get(k + 1));
                        for(int i = k + 1; i < a.getRowSize(); i++) {
                            Scalar d = (Scalar) t.mult(w.get(i));
                            a.set(i, j, (Scalar) a.get(i, j).plus(d));
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
            if(s.get(k, k).absolute().compareTo((Type)EPS_SCALAR) == 1) {
                for(int j = k + 1; j < n; j++) {
                    Scalar t = Scalar.ZERO;
                    for(int i = k; i < a.getRowSize(); i++) {
                        Scalar d = (Scalar) u.get(i, k).mult(u.get(i, j));
                        t = (Scalar) t.plus(d);
                    }
                    t = (Scalar) t.neg().div(u.get(k, k));
                    for(int i = k; i < a.getRowSize(); i++) {
                        Scalar d = (Scalar) t.mult(u.get(i, k));
                        u.set(i, j, (Scalar) u.get(i, j).plus(d));
                    }
                }
                for(int i = k; i < a.getRowSize(); i++) {
                    u.set(i, k, (Scalar) u.get(i, k).neg());
                }
                u.set(k, k, (Scalar) u.get(k, k).plus(Scalar.ONE));
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
            if((k < nr) & (e.get(k).absolute().compareTo((Type)EPS_SCALAR) == 1)) {
                for(int j = k + 1; j < n; j++) {
                    Scalar t = Scalar.ZERO;
                    for(int i = k + 1; i < a.getColumnSize(); i++) {
                        Scalar d = (Scalar) v.get(i, k).mult(v.get(i, j));
                        t = (Scalar) t.plus(d);
                    }
                    t = (Scalar) t.neg().div(v.get(k + 1, k));
                    for(int i = k + 1; i < a.getColumnSize(); i++) {
                        Scalar d = (Scalar) t.mult(v.get(i, k));
                        v.set(i, j, (Scalar) v.get(i, j).plus(d));
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
                    Scalar t = (Scalar) (ks != p ? e.get(ks).absolute() : Scalar.ZERO)
                            .plus((ks != k + 1 ? e.get(ks - 1).absolute() : Scalar.ZERO));
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
                        Scalar t = hypot(s.get(j, j), f);
                        Scalar cs = (Scalar) s.get(j, j).div(t);
                        Scalar sn = (Scalar) f.div(t);
                        s.set(j, j, t);
                        if(j != k) {
                            f = (Scalar) sn.neg().mult(e.get(j - 1));
                            e.set(j - 1, (Scalar)cs.mult(e.get(j - 1)));
                        }
                        for(int i = 0; i < a.getColumnSize(); i++) {
                            Scalar l = (Scalar) cs.mult(v.get(i, j));
                            Scalar r = (Scalar) sn.mult(v.get(i, p - 1));
                            t = (Scalar) l.plus(r);
                            Scalar vl = (Scalar) sn.neg().mult(v.get(i, j));
                            Scalar vr = (Scalar) cs.mult(v.get(i, p - 1));
                            v.set(i , p - 1, (Scalar) vl.plus(vr));
                            v.set(i, j, t);
                        }
                    }
                }
                    break;
                case 2: {
                    Scalar f = e.get(k - 1);
                    e.set(k - 1, Scalar.ZERO);
                    for(int j = k; j < p; j++) {
                        Scalar t = hypot(s.get(j, j), f);
                        Scalar cs = (Scalar) s.get(j, j).div(t);
                        Scalar sn = (Scalar) f.div(t);
                        s.set(j, j, t);
                        f = (Scalar) sn.neg().mult(e.get(j));
                        e.set(j, (Scalar) cs.mult(e.get(j)));
                        for(int i = 0; i < a.getRowSize(); i++) {
                            Scalar l = (Scalar) cs.mult(u.get(i, j));
                            Scalar r = (Scalar) sn.mult(u.get(i, k - 1));
                            t = (Scalar) l.plus(r);
                            Scalar ul = (Scalar) sn.neg().mult(u.get(i, j));
                            Scalar ur = (Scalar) cs.mult(u.get(i, k - 1));
                            u.set(i, k - 1, (Scalar)ul.plus(ur));
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
                    Scalar sp = (Scalar) s.get(p - 1, p - 1).div(scale);
                    Scalar spm1 = (Scalar) s.get(p - 2, p - 2).div(scale);
                    Scalar epm1 = (Scalar) e.get(p - 2).div(scale);
                    Scalar sk = (Scalar) s.get(k, k).div(scale);
                    Scalar ekk = (Scalar) e.get(k).div(scale);
                    Scalar lb = (Scalar) spm1.plus(sp); Scalar rb = (Scalar) spm1.minus(sp);
                    Scalar rrb = (Scalar) epm1.mult(epm1); Scalar llb = (Scalar) lb.mult(rb);
                    Scalar b = (Scalar) llb.plus(rrb).div(new Scalar(2.0));
                    Scalar c = (Scalar) sp.mult(epm1).mult((sp.mult(epm1)));
                    Scalar shift = Scalar.ZERO;
                    if((!b.equals(Scalar.ZERO)) | (!c.equals(Scalar.ZERO))) {
                        shift = new Scalar(Math.sqrt(((Scalar) b.mult(b).plus(c)).doubleValue()));
                        if(b.compareTo((Type)Scalar.ZERO) == -1) {
                            shift = (Scalar) shift.neg();
                        }
                        shift = (Scalar) c.div(b.plus(shift));
                    }
                    Scalar f = (Scalar) (sk.plus(sp).mult(sk.minus(sp))).plus(shift);
                    Scalar g = (Scalar) sk.mult(ekk);
                    for(int j = k; j < p - 1; j++) {
                        Scalar t = hypot(f, g);
                        Scalar cs = (Scalar) f.div(t);
                        Scalar sn = (Scalar) g.div(t);
                        if(j != k) {
                            e.set(j - 1, t);
                        }
                        f = (Scalar) cs.mult(s.get(j, j)).plus(sn.mult(e.get(j)));
                        e.set(j, (Scalar) cs.mult(e.get(j)).minus(sn.mult(s.get(j, j))));
                        g = (Scalar) sn.mult(s.get(j + 1, j + 1));
                        s.set(j + 1, j + 1, (Scalar) cs.mult(s.get(j + 1, j + 1)));
                        for(int i = 0; i < a.getColumnSize(); i++) {
                            t = (Scalar) cs.mult(v.get(i, j)).plus(sn.mult(v.get(i, j + 1)));
                            v.set(i, j + 1, (Scalar) sn.neg().mult(v.get(i, j)).plus(cs.mult(v.get(i, j + 1))));
                            v.set(i, j, t);
                        }
                        t = hypot(f, g);
                        cs = (Scalar) f.div(t);
                        sn = (Scalar) g.div(t);
                        s.set(j, j, t);
                        f = (Scalar) cs.mult(e.get(j)).plus(sn.mult(s.get(j + 1, j + 1)));
                        s.set(j + 1, j + 1, (Scalar) sn.neg().mult(e.get(j)).plus(cs.mult(s.get(j + 1, j + 1))));
                        g = (Scalar) sn.mult(e.get(j + 1));
                        e.set(j + 1, (Scalar) e.get(j + 1).mult(cs));
                        if(j < a.getRowSize() - 1) {
                            for(int i = 0; i < a.getRowSize(); i++) {
                                t =  (Scalar) cs.mult(u.get(i, j)).plus(sn.mult(u.get(i, j + 1)));
                                u.set(i, j + 1, (Scalar) sn.neg().mult(u.get(i, j)).plus(cs.mult(u.get(i, j + 1))));
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
                        s.set(k, k, skk < 0.0 ? (Scalar) s.get(k, k).neg() : Scalar.ZERO);
                        for(int i = 0; i <= pp; i++) {
                            v.set(i, k, (Scalar) v.get(i, k).neg());
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

    private Scalar hypot(Scalar a, Scalar b) {
        Scalar result;
        if(a.absolute().compareTo((Type)b.absolute()) == 1) {
            Scalar e = (Scalar) b.div(a);
            double ed = e.doubleValue();
            Scalar f = new Scalar(Math.sqrt(1 + ed * ed));
            result = (Scalar) a.absolute().mult(f);
        } else if(!b.equals(Scalar.ZERO)) {
            Scalar e = (Scalar) a.div(b);
            double ed = e.doubleValue();
            Scalar f = new Scalar(Math.sqrt(1 + ed * ed));
            result = (Scalar) b.absolute().mult(f);
        } else {
            result = Scalar.ZERO;
        }
        return result;
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
