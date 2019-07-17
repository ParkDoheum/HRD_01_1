package hrd;

public class ProductVo {
	private String tableNm;
	private String flag = "";
	private int i_no;
	private int p_no;
	private String p_name;
	private int i_cnt;
	private int p_cnt;
	private String i_date;
			
	public int getP_cnt() {
		return p_cnt;
	}
	public void setP_cnt(int p_cnt) {
		this.p_cnt = p_cnt;
	}
	public String getTableNm() {
		return tableNm;
	}
	public void setTableNm(String tableNm) {
		this.tableNm = tableNm;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getI_no() {
		return i_no;
	}
	public void setI_no(int i_no) {
		this.i_no = i_no;
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getI_cnt() {
		return i_cnt;
	}
	public void setI_cnt(int i_cnt) {
		this.i_cnt = i_cnt;
	}
	public String getI_date() {
		return i_date;
	}
	public void setI_date(String i_date) {
		this.i_date = i_date;
	}
}
