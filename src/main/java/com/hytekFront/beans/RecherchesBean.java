package com.hytekFront.beans;

import java.sql.Date;

public class RecherchesBean {

	private int id;
	private int fk_user;
	private String motcle;
	private Date date;
	private boolean archiver;

	private UtilisateursBean user;

	public RecherchesBean() {
		super();
	}

	public RecherchesBean(int id, int fk_user, String motcle, Date date, boolean archiver, UtilisateursBean user) {
		super();
		this.id = id;
		this.fk_user = fk_user;
		this.motcle = motcle;
		this.date = date;
		this.archiver = archiver;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFk_user() {
		return fk_user;
	}

	public void setFk_user(int fk_user) {
		this.fk_user = fk_user;
	}

	public String getMotcle() {
		return motcle;
	}

	public void setMotcle(String motcle) {
		this.motcle = motcle;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	public UtilisateursBean getUser() {
		return user;
	}

	public void setUser(UtilisateursBean user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "RecherchesBean [id=" + id + ", fk_user=" + fk_user + ", motcle=" + motcle + ", date=" + date
				+ ", archiver=" + archiver + ", user=" + user + "]";
	}

}