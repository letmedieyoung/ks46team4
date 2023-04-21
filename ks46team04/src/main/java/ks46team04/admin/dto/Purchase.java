package ks46team04.admin.dto;

public class Purchase {
	private String purchaseCode;		
	private String purchaseStatus;	
	private String goodsCode;	//이건 외래키, 일대다 관계와 다대일 관계를 생각		
	private String goodsName;		
	private String purchasePrice;		
	private String purchaseQuantity;		
	private String totalPurchasePrice;		
	private String purchaseDate;		
	private String purchaseRegId;		
	private String purchaseRegDate;		
	private String purchaseUpdateId;		
	private String purchaseUpdateDate;		
	private String purchaseGroupCode;		
	private String userPurchseDeadlindeCheck;
	
	
	public String getPurchaseCode() {
		return purchaseCode;
	}
	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}
	public String getPurchaseStatus() {
		return purchaseStatus;
	}
	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(String purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public String getTotalPurchasePrice() {
		return totalPurchasePrice;
	}
	public void setTotalPurchasePrice(String totalPurchasePrice) {
		this.totalPurchasePrice = totalPurchasePrice;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getPurchaseRegId() {
		return purchaseRegId;
	}
	public void setPurchaseRegId(String purchaseRegId) {
		this.purchaseRegId = purchaseRegId;
	}
	public String getPurchaseRegDate() {
		return purchaseRegDate;
	}
	public void setPurchaseRegDate(String purchaseRegDate) {
		this.purchaseRegDate = purchaseRegDate;
	}
	public String getPurchaseUpdateId() {
		return purchaseUpdateId;
	}
	public void setPurchaseUpdateId(String purchaseUpdateId) {
		this.purchaseUpdateId = purchaseUpdateId;
	}
	public String getPurchaseUpdateDate() {
		return purchaseUpdateDate;
	}
	public void setPurchaseUpdateDate(String purchaseUpdateDate) {
		this.purchaseUpdateDate = purchaseUpdateDate;
	}
	public String getPurchaseGroupCode() {
		return purchaseGroupCode;
	}
	public void setPurchaseGroupCode(String purchaseGroupCode) {
		this.purchaseGroupCode = purchaseGroupCode;
	}
	public String getUserPurchseDeadlindeCheck() {
		return userPurchseDeadlindeCheck;
	}
	public void setUserPurchseDeadlindeCheck(String userPurchseDeadlindeCheck) {
		this.userPurchseDeadlindeCheck = userPurchseDeadlindeCheck;
	}
	
	
	@Override
	public String toString() {
		return "Purchase [purchaseCode=" + purchaseCode + ", purchaseStatus=" + purchaseStatus + ", goodsCode="
				+ goodsCode + ", goodsName=" + goodsName + ", purchasePrice=" + purchasePrice + ", purchaseQuantity="
				+ purchaseQuantity + ", totalPurchasePrice=" + totalPurchasePrice + ", purchaseDate=" + purchaseDate
				+ ", purchaseRegId=" + purchaseRegId + ", purchaseRegDate=" + purchaseRegDate + ", purchaseUpdateId="
				+ purchaseUpdateId + ", purchaseUpdateDate=" + purchaseUpdateDate + ", purchaseGroupCode="
				+ purchaseGroupCode + ", userPurchseDeadlindeCheck=" + userPurchseDeadlindeCheck + "]";
	}	
}
