package com.ksmessaging.api.privategroup.invitation;

import org.briarproject.bramble.api.contact.Contact;
import com.ksmessaging.api.privategroup.PrivateGroup;
import com.ksmessaging.api.sharing.InvitationItem;
import org.briarproject.nullsafety.NotNullByDefault;

import javax.annotation.concurrent.Immutable;

@Immutable
@NotNullByDefault
public class GroupInvitationItem extends InvitationItem<PrivateGroup> {

	private final Contact creator;

	public GroupInvitationItem(PrivateGroup privateGroup, Contact creator) {
		super(privateGroup, false);
		this.creator = creator;
	}

	public Contact getCreator() {
		return creator;
	}

}
