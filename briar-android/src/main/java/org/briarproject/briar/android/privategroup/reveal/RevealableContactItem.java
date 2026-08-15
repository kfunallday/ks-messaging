package com.ksmessaging.android.privategroup.reveal;

import org.briarproject.bramble.api.contact.Contact;
import com.ksmessaging.android.contactselection.BaseSelectableContactItem;
import com.ksmessaging.api.identity.AuthorInfo;
import com.ksmessaging.api.privategroup.Visibility;
import org.briarproject.nullsafety.NotNullByDefault;

import javax.annotation.concurrent.NotThreadSafe;

import static com.ksmessaging.api.privategroup.Visibility.INVISIBLE;

@NotThreadSafe
@NotNullByDefault
class RevealableContactItem extends BaseSelectableContactItem {

	private final Visibility visibility;

	RevealableContactItem(Contact contact, AuthorInfo authorInfo,
			boolean selected, Visibility visibility) {
		super(contact, authorInfo, selected);
		this.visibility = visibility;
	}

	Visibility getVisibility() {
		return visibility;
	}

	@Override
	public boolean isDisabled() {
		return visibility != INVISIBLE;
	}
}
