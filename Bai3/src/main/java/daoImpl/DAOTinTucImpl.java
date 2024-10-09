package daoImpl;

import java.util.ArrayList;
import java.util.List;

import dao.DAOTinTucInterface;
import entities.DanhMuc;
import entities.TinTuc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAOTinTucImpl implements DAOTinTucInterface{
	private EntityManager en;
	
	public DAOTinTucImpl(EntityManager en) {
		this.en = en;
	}
	
	@Override
	public boolean themTinTuc(TinTuc tinTuc) {
		EntityTransaction trans = null;
		try {
			trans = en.getTransaction();
			trans.begin();
			en.persist(tinTuc);
			trans.commit();
			return true;
		} catch (Exception e) {
			if (trans != null && trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<TinTuc> getAllTinTuc() {
		List<TinTuc> ds = new ArrayList<TinTuc>();
		try {
			ds = en.createQuery("SELECT t FROM TinTuc t", TinTuc.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public boolean removeTinTuc(int id) {
		EntityTransaction trans = null;
		try {
			trans = en.getTransaction();
			trans.begin();
			TinTuc tinTuc = en.find(TinTuc.class, id);
			if (tinTuc != null) {
				en.remove(tinTuc);
				trans.commit();
				return true;
			} else {
				if (trans != null && trans.isActive()) {
					trans.rollback();
				}
			}
			
			return true;
		} catch (Exception e) {
			if (trans != null && trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<TinTuc> getTinTucByDanhMuc(int id) {
		List<TinTuc> ds = new ArrayList<TinTuc>();
		try {
			ds = en.createQuery("SELECT t FROM TinTuc t WHERE t.danhMuc.maDM = :id", TinTuc.class)
			.setParameter("id", id)		
			.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
//	@Override
//	public List<Object[]> getTinTucByDanhMuc() {
//		String jpql = "SELECT d.tenDanhMuc, t.maDM, t.maTT, t.lienKet, t.noiDungTT, t.tieuDe " +
//			       "FROM TinTuc t JOIN t.danhMuc d " +
//			       "ORDER BY d.tenDanhMuc ASC";
//		List<Object[]> ds = new ArrayList<Object[]>();
//		try {
//			ds = en.createQuery(jpql, Object[].class).getResultList();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return ds;
//	}
	
}
