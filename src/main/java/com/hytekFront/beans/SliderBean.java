package com.hytekFront.beans;

public class SliderBean {
	
	// ATTRIBUTES
		private int id;
		private String titre;
		private String description;
		private String titreBouton;
		private String url;
		private String image;
		private boolean archiver;

		// CONSTRUCTORS
		public SliderBean() {
			super();
		}

		public SliderBean(int id, String titre, String description, String titreBouton, String url, String image, boolean archiver) {
			super();
			this.id = id;
			this.titre = titre;
			this.description = description;
			this.titreBouton = titreBouton;
			this.url = url;
			this.image = image;
			this.archiver = archiver;
		}

		// PROPERTIES
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getTitreBouton() {
			return titreBouton;
		}

		public void setTitreBouton(String titreBouton) {
			this.titreBouton = titreBouton;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public boolean isArchiver() {
			return archiver;
		}

		public void setArchiver(boolean archiver) {
			this.archiver = archiver;
		}

		@Override
		public String toString() {
			return "SliderBean [id=" + id + ", titre=" + titre + ", description=" + description + ", titreBouton="
					+ titreBouton + ", url=" + url + ", image=" + image + ", archiver=" + archiver + "]";
		}

}
