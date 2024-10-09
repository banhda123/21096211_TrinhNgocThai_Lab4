package dao;

import java.util.List;

import entities.DanhMuc;

public interface DAODanhMucInterface {
	public boolean addDanhMuc(DanhMuc dm);
	public List<DanhMuc> getAllDanhMuc();
	public int getIdByName(String name);
	public DanhMuc getDanhMucById(int id);
}
