package daoImpl;

import java.util.ArrayList;
import java.util.List;

import dao.DAODanhMucInterface;
import entities.DanhMuc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAODanhMucImpl implements DAODanhMucInterface{
	private EntityManager en;
	
	public DAODanhMucImpl(EntityManager en) {
		this.en = en;
	}

	@Override
	public boolean addDanhMuc(DanhMuc dm) {
		EntityTransaction trans = null;
		try {
			trans = en.getTransaction();
			trans.begin();
			en.persist(dm);
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
	public List<DanhMuc> getAllDanhMuc() {
		List<DanhMuc> ds = new ArrayList<DanhMuc>();
		try {
			ds = en.createQuery("SELECT dm FROM DanhMuc dm", DanhMuc.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public DanhMuc getDanhMucById(int id) {
		DanhMuc danhMuc = null;
		try {
			danhMuc = (DanhMuc) en.createQuery("SELECT dm FROM DanhMuc dm WHERE dm.maDM = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhMuc;
	}
	
	@Override
	public int getIdByName(String name) {
		int id = -1;
		try {
			id = (int) en.createQuery("SELECT dm.maDM FROM DanhMuc dm WHERE dm.tenDanhMuc = :name")
					.setParameter("name", name)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
}
