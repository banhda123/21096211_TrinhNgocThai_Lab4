package entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DanhMuc")
public class DanhMuc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maDM;
	private String tenDanhMuc;
	private String nguoiQuanLy;
	private String ghiChu;
	
	@OneToMany(mappedBy = "danhMuc")
	private List<TinTuc> tinTucs;

	public DanhMuc() {
		super();
	}

	public DanhMuc(int maDM, String tenDanhMuc, String nguoiQuanLy, String ghiChu, List<TinTuc> tinTucs) {
		super();
		this.maDM = maDM;
		this.tenDanhMuc = tenDanhMuc;
		this.nguoiQuanLy = nguoiQuanLy;
		this.ghiChu = ghiChu;
		this.tinTucs = tinTucs;
	}

	public DanhMuc(String tenDanhMuc, String nguoiQuanLy, String ghiChu) {
		super();
		this.tenDanhMuc = tenDanhMuc;
		this.nguoiQuanLy = nguoiQuanLy;
		this.ghiChu = ghiChu;
	}

	public int getMaDM() {
		return maDM;
	}

	public void setMaDM(int maDM) {
		this.maDM = maDM;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public String getNguoiQuanLy() {
		return nguoiQuanLy;
	}

	public void setNguoiQuanLy(String nguoiQuanLy) {
		this.nguoiQuanLy = nguoiQuanLy;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public List<TinTuc> getTinTucs() {
		return tinTucs;
	}

	public void setTinTucs(List<TinTuc> tinTucs) {
		this.tinTucs = tinTucs;
	}

	@Override
	public String toString() {
		return "DanhMuc [maDM=" + maDM + ", tenDanhMuc=" + tenDanhMuc + ", nguoiQuanLy=" + nguoiQuanLy + ", ghiChu="
				+ ghiChu + "]";
	}
	
	
}
