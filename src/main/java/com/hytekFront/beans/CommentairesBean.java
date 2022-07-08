package com.hytekFront.beans;

import java.sql.Date;

public class CommentairesBean {

	private int id;
	private String commentaire;
	private int note;
	private Date date;
	private int fk_prod;
	private int fk_user;
	private boolean archiver;

	public CommentairesBean() {
		super();
	}

	public CommentairesBean(int id, String commentaire, int note, Date date, int fk_prod, int fk_user,
			boolean archiver) {
		super();
		this.id = id;
		this.commentaire = commentaire;
		this.note = note;
		this.date = date;
		this.fk_prod = fk_prod;
		this.fk_user = fk_user;
		this.archiver = archiver;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getFk_prod() {
		return fk_prod;
	}

	public void setFk_prod(int fk_prod) {
		this.fk_prod = fk_prod;
	}

	public int getFk_user() {
		return fk_user;
	}

	public void setFk_user(int fk_user) {
		this.fk_user = fk_user;
	}

	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

}