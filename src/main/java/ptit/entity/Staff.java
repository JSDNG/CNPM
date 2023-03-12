package ptit.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "staff")
public class Staff implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name ="staffID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long staffID;
	
	@Size(min = 1, max = 225, message = "Tên nhân viên phải từ 1-225 kí tự")
	@NotEmpty(message = "Vui lòng nhập name")
	@Column(name = "fullname", length = 225)
	private String fullname;
	
	private boolean sex;
	
	@Size(min = 9, max = 12, message = "Số điện thoại phải từ 9-12 kí tự")
	@NotEmpty(message = "Vui lòng nhập số điện thoại")
	@Column(nullable = false, length = 15)
	private String phone;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date birth;
	
	@Size(min = 12, max = 12, message = "Căn cước công dân 12 kí tự ")
	@NotEmpty(message = "Vui lòng nhập căn cước công dân")
	@Column(name ="cccd")
	private String cccd;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staff", cascade = CascadeType.ALL)
    private Collection<Order> order;
	
//	@OneToOne(mappedBy="staffID")
//	private Account account;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountID")
	private Account account;
	
	public Staff() {
		
	}

	public Long getStaffID() {
		return staffID;
	}

	public void setStaffID(Long staffID) {
		this.staffID = staffID;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public boolean getSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public Collection<Order> getOrder() {
		return order;
	}

	public void setOrder(Collection<Order> order) {
		this.order = order;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
