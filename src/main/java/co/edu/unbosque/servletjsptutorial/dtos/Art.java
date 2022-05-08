package co.edu.unbosque.servletjsptutorial.dtos;

import com.opencsv.bean.CsvBindByName;

public class Art {
	
	@CsvBindByName(column = "title")
	private String title;
	
	@CsvBindByName(column = "fcoinsprice")
	private int fcoinsprice;
	
	@CsvBindByName(column = "image")
	private String image;

	public String getTitle() {
		return title;
	}

	public int getFcoinsprice() {
		return fcoinsprice;
	}

	public void setFcoinsprice(int fcoinsprice) {
		this.fcoinsprice = fcoinsprice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Art [title=" + title + ", fcoinsprice=" + fcoinsprice + ", image=" + image + "]";
	}


		
	
}
