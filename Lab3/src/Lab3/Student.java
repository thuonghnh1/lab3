package Lab3;

public class Student {
	private String fullname;
	private String nganh;
	private double mark;

	public String hocLuc() {
		if (this.mark < 3) {
			return "Kém";
		}
		if (this.mark < 5) {
			return "Yếu";
		}
		if (this.mark < 6.5) {
			return "Trung bình";
		}
		if (this.mark < 7.5) {
			return "Khá";
		}
		if (this.mark < 9) {
			return "Giỏi";
		}
		return "Xuất sắc";
	}

	public boolean isBonus() {
		return this.mark >= 7.5;
	}

	public Student() {
		super();
	}

	public Student(String fullname, double mark, String nganh) {
		super();
		this.fullname = fullname;
		this.nganh = nganh;
		this.mark = mark;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getNganh() {
		return nganh;
	}

	public void setNganh(String nganh) {
		this.nganh = nganh;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

}
