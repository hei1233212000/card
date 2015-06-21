package com.lado.model.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;

@Entity
@Table(name = "NAME_CARD")
public class NameCard extends UpdateableBaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String address;

	@Column
	private String phoneNumber;

	@Column
	private String company;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("id", id)
				.add("super", super.toString())
				.add("name", name)
				.add("email", email)
				.add("address", address)
				.add("phoneNumber", phoneNumber)
				.add("company", company)
				.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public static class Builder extends UpdateableBaseEntityBuilder<NameCard, Builder> {
		private Long id;
		private String name;
		private String email;
		private String address;
		private String phoneNumber;
		private String company;

		@Override
		protected NameCard newEntity() {
			return new NameCard();
		}

		@Override
		protected Builder getThis() {
			return this;
		}

		public Builder id(Long id) {
			this.id = id;
			return getThis();
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Builder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public Builder company(String company) {
			this.company = company;
			return this;
		}

		@Override
		public NameCard build() {
			NameCard nameCard = super.build();
			nameCard.id = id;
			nameCard.name = name;
			nameCard.email = email;
			nameCard.address = address;
			nameCard.phoneNumber = phoneNumber;
			nameCard.company = company;
			return nameCard;
		}
	}
}
