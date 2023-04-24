package ks46team04.admin.dto;

public class Purchase {
	private String purchaseCode;		
	private String purchaseStatus;	
	private String goodsCode;	
	private String goodsName;		
	private int purchasePrice;		
	private int purchaseQuantity;		
	private int totalPurchasePrice;		
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
	public int getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public int getTotalPurchasePrice() {
		return totalPurchasePrice;
	}
	public void setTotalPurchasePrice(int totalPurchasePrice) {
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
		StringBuilder builder = new StringBuilder();
		builder.append("Purchase [purchaseCode=");
		builder.append(purchaseCode);
		builder.append(", purchaseStatus=");
		builder.append(purchaseStatus);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", goodsName=");
		builder.append(goodsName);
		builder.append(", purchasePrice=");
		builder.append(purchasePrice);
		builder.append(", purchaseQuantity=");
		builder.append(purchaseQuantity);
		builder.append(", totalPurchasePrice=");
		builder.append(totalPurchasePrice);
		builder.append(", purchaseDate=");
		builder.append(purchaseDate);
		builder.append(", purchaseRegId=");
		builder.append(purchaseRegId);
		builder.append(", purchaseRegDate=");
		builder.append(purchaseRegDate);
		builder.append(", purchaseUpdateId=");
		builder.append(purchaseUpdateId);
		builder.append(", purchaseUpdateDate=");
		builder.append(purchaseUpdateDate);
		builder.append(", purchaseGroupCode=");
		builder.append(purchaseGroupCode);
		builder.append(", userPurchseDeadlindeCheck=");
		builder.append(userPurchseDeadlindeCheck);
		builder.append("]");
		return builder.toString();
	}
	
}
