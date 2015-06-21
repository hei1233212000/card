package com.lado.model.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER_DEVICE_NAME_CARD_MAPPING")
public class UserDeviceNameCardMapping extends SimpleBaseEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserDeviceNameCardMappingPk pk;

	@ManyToOne
	@JoinColumn(name = "NAME_CARD_ID", nullable = false, insertable = false, updatable = false)
	private NameCard nameCard;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("pk", pk)
				.add("super", super.toString())
				.toString();
	}

	public UserDeviceNameCardMappingPk getPk() {
		return pk;
	}

	public void setPk(UserDeviceNameCardMappingPk pk) {
		this.pk = pk;
	}

	public NameCard getNameCard() {
		return nameCard;
	}

	public void setNameCard(NameCard nameCard) {
		this.nameCard = nameCard;
	}

	@Embeddable
	public static class UserDeviceNameCardMappingPk implements Serializable {
		private static final long serialVersionUID = 1L;

		@Column(name = "USER_DEVICE_ID")
		private String userDeviceId;

		@Column(name = "NAME_CARD_ID")
		private Long nameCardId;

		@Override
		public String toString() {
			return MoreObjects.toStringHelper(this)
					.add("userDeviceId", userDeviceId)
					.add("nameCardId", nameCardId)
					.toString();
		}

		@Override
		public int hashCode() {
			return userDeviceId == null || nameCardId == null ? 0 : (userDeviceId + Long.toString(nameCardId)).hashCode();
		}

		@Override
		public boolean equals(Object other) {
			if (userDeviceId == null || nameCardId == null) return false;
			if (other instanceof UserDeviceNameCardMappingPk) {
				UserDeviceNameCardMappingPk otherPk = (UserDeviceNameCardMappingPk) other;
				return userDeviceId.equals(otherPk.userDeviceId) && nameCardId.equals(otherPk.nameCardId);
			}
			return false;
		}

		public String getUserDeviceId() {
			return userDeviceId;
		}

		public void setUserDeviceId(String userDeviceId) {
			this.userDeviceId = userDeviceId;
		}

		public Long getNameCardId() {
			return nameCardId;
		}

		public void setNameCardId(Long nameCardId) {
			this.nameCardId = nameCardId;
		}

		public static class Builder {
			private String userDeviceId;
			private Long nameCardId;

			public Builder userDeviceId(String userDeviceId) {
				this.userDeviceId = userDeviceId;
				return this;
			}

			public Builder nameCardId(Long nameCardId) {
				this.nameCardId = nameCardId;
				return this;
			}

			public UserDeviceNameCardMappingPk build() {
				UserDeviceNameCardMappingPk rolePermissionPk = new UserDeviceNameCardMappingPk();
				rolePermissionPk.setUserDeviceId(userDeviceId);
				rolePermissionPk.setNameCardId(nameCardId);
				return rolePermissionPk;
			}

		}
	}

	public static class Builder extends SimpleBaseEntityBuilder<UserDeviceNameCardMapping, Builder> {
		private UserDeviceNameCardMappingPk pk;

		@Override
		protected UserDeviceNameCardMapping newEntity() {
			return new UserDeviceNameCardMapping();
		}

		@Override
		protected Builder getThis() {
			return this;
		}

		public Builder pk(UserDeviceNameCardMappingPk pk) {
			this.pk = pk;
			return this;
		}

		@Override
		public UserDeviceNameCardMapping build() {
			UserDeviceNameCardMapping userDeviceNameCardMapping = super.build();
			userDeviceNameCardMapping.pk = pk;
			return userDeviceNameCardMapping;
		}
	}
}
