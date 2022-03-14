package com.example.travel.domain;

import java.util.List;

public class Spot {
	private long id;
	private int greatNum;
	private String name;
	private String address;
	private String time;
	private String way;
	private double price;
	private String description;
	private String bigimg;
	private String theme;
	private String traffic;
	private String food;
	private int status=0;
	private long  userId;
	private List<Image> images;
	private List<Comment> commentList;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBigimg() {
		return bigimg;
	}
	public void setBigimg(String bigimg) {
		this.bigimg = bigimg;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getTraffic() {
		return traffic;
	}
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public int getGreatNum() {
		return greatNum;
	}

	public void setGreatNum(int greatNum) {
		this.greatNum = greatNum;
	}

	@Override
	public String toString() {
		return "Spot [id=" + id + ", name=" + name + ", address=" + address + ", time=" + time + ", way=" + way
				+ ", price=" + price + ", description=" + description + ", bigimg=" + bigimg + ", theme=" + theme
				+ ", traffic=" + traffic + ", food=" + food + ", status=" + status + ", userId=" + userId + ", images="
				+ images + ", commentList=" + commentList + "]";
	}
	

}
