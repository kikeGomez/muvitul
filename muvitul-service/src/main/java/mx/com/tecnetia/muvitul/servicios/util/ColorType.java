package mx.com.tecnetia.muvitul.servicios.util;

public enum ColorType {
	BLUE(1), YELLOW(2), RED(3);
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	ColorType(int type) {
		this.setType(type);
	}

}