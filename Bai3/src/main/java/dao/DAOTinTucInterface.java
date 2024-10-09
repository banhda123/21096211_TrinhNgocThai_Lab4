package dao;

import java.util.List;

import entities.TinTuc;

public interface DAOTinTucInterface {
	public boolean themTinTuc(TinTuc tinTuc);
	public List<TinTuc> getAllTinTuc();
	public boolean removeTinTuc(int id);
//	public List<Object[]> getTinTucByDanhMuc();
	public List<TinTuc> getTinTucByDanhMuc(int id);
	
}
