
package IMDb;

public class ExcelRow{
		private String wPlace;
		private String wDate;
		private String uPlace;
		private String uDate;
		private String uKPlace;
		private String uKDate;
		private String gPlace;
		private String gDate;
		private String iPlace;
		private String iDate;
		private String movieId;
		
		public String getMovieId() {
			return movieId;
		}

		public void setMovieId(String movieId) {
			this.movieId = movieId;
		}

		public String getuPlace() {
			return uPlace;
		}

		public void setuPlace(String uPlace) {
			this.uPlace = uPlace;
		}

		public String getuDate() {
			return uDate;
		}

		public void setuDate(String uDate) {
			this.uDate = uDate;
		}

		public String getuKPlace() {
			return uKPlace;
		}

		public void setuKPlace(String uKPlace) {
			this.uKPlace = uKPlace;
		}

		public String getuKDate() {
			return uKDate;
		}

		public void setuKDate(String uKDate) {
			this.uKDate = uKDate;
		}

		public String getgPlace() {
			return gPlace;
		}

		public void setgPlace(String gPlace) {
			this.gPlace = gPlace;
		}

		public String getgDate() {
			return gDate;
		}

		public void setgDate(String gDate) {
			this.gDate = gDate;
		}

		public String getiPlace() {
			return iPlace;
		}

		public void setiPlace(String iPlace) {
			this.iPlace = iPlace;
		}

		public String getiDate() {
			return iDate;
		}

		public void setiDate(String iDate) {
			this.iDate = iDate;
		}

		public void setwPlace(String wPlace) {
			this.wPlace = wPlace;
		}

		public void setwDate(String wDate) {
			this.wDate = wDate;
		}
		
		public void setPlace(String wPlace){
			this.wPlace = wPlace;
		}
		
		public void setDate(String wDate){
			this.wDate = wDate;
		}
		
		public String getwPlace(){
			return wPlace;
		}
		
		public String getwDate(){
			return wDate;
		}
	}
