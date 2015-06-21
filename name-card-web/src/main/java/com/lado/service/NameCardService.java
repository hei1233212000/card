package com.lado.service;

import com.avaje.ebean.*;
import com.google.common.base.Function;
import com.lado.model.entity.NameCard;
import com.lado.model.entity.UserDeviceNameCardMapping;
import com.lado.model.pojo.BoNameCard;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@Service
public class NameCardService {
	private EbeanServer ebeanServer;

	@Inject
	public NameCardService(EbeanServer ebeanServer) {
		this.ebeanServer = ebeanServer;
	}

	/**
	 * Null may be returned
	 */
	public NameCard find(long id) {
		return ebeanServer.find(NameCard.class, id);
	}

	public List<NameCard> findAll() {
		return ebeanServer.find(NameCard.class).findList();
	}

	/**
	 * Process the NameCard either create or update
	 * 1. if it is not exist in the DB, create it
	 * 2. if it is already exist, update it
	 */
	public NameCard createOrUpdate(BoNameCard boNameCard) {
		// TODO: determine to create or update
		NameCard existingNameCard = findExistingNameCard(boNameCard);
		// check if the NameCard is already exist
		if (existingNameCard == null) {
			// if it is not exist in the DB, create it
			String userDeviceId = boNameCard.getUserDeviceId();
			NameCard nameCard = new NameCard2BoNameCard().apply(boNameCard);
			Transaction tx = ebeanServer.beginTransaction();
			try {
				// create NameCard record
				ebeanServer.save(nameCard);
				UserDeviceNameCardMapping userDeviceNameCardMapping = new UserDeviceNameCardMapping.Builder()
						.pk(new UserDeviceNameCardMapping.UserDeviceNameCardMappingPk.Builder()
								.userDeviceId(userDeviceId)
								.nameCardId(nameCard.getId()).build())
						.build();
				// create mapping table
				ebeanServer.save(userDeviceNameCardMapping);
				return nameCard;
			} catch (Exception e) {
				tx.rollback();
				throw e;
			} finally {
				tx.commit();
			}
		} else {
			// if all fields are equal => return
			if (nameCardNoChange(existingNameCard, new NameCard2BoNameCard().apply(boNameCard))) return existingNameCard;
			// if it is already exist, update it
			existingNameCard.setAddress(boNameCard.getAddress());
			existingNameCard.setCompany(boNameCard.getCompany());
			existingNameCard.setEmail(boNameCard.getEmail());
			existingNameCard.setName(boNameCard.getName());
			existingNameCard.setPhoneNumber(boNameCard.getPhoneNumber());
			ebeanServer.update(existingNameCard);
			return existingNameCard;
		}
	}

	private NameCard findExistingNameCard(BoNameCard boNameCard) {
		Query<NameCard> query = ebeanServer.find(NameCard.class);
		ExpressionList<NameCard> expressionList =
				query.where().or(Expr.eq("email", boNameCard.getEmail()), Expr.eq("phoneNumber", boNameCard.getPhoneNumber()));
		return expressionList.findUnique();
	}

	private boolean nameCardNoChange(NameCard existingNameCard, NameCard newNameCard) {
		return Objects.equals(existingNameCard.getAddress(), newNameCard.getAddress())
					&& Objects.equals(existingNameCard.getCompany(), newNameCard.getCompany())
					&& Objects.equals(existingNameCard.getEmail(), newNameCard.getEmail())
					&& Objects.equals(existingNameCard.getName(), newNameCard.getName())
					&& Objects.equals(existingNameCard.getPhoneNumber(), newNameCard.getPhoneNumber());
	}

	private static class NameCard2BoNameCard implements Function<BoNameCard, NameCard> {
		@Override
		public NameCard apply(BoNameCard input) {
			if (input == null) return null;
			return new NameCard.Builder()
					.name(input.getName())
					.address(input.getAddress())
					.company(input.getCompany())
					.email(input.getEmail())
					.phoneNumber(input.getPhoneNumber())
					.build();
		}
	}
}
