package com.ksmessaging.android.sharing;

import org.briarproject.bramble.api.contact.ContactId;
import org.briarproject.bramble.api.db.DbException;
import org.briarproject.bramble.api.sync.GroupId;
import com.ksmessaging.android.contactselection.ContactSelectorController;
import com.ksmessaging.android.contactselection.SelectableContactItem;
import com.ksmessaging.android.controller.handler.ExceptionHandler;

import java.util.Collection;

import javax.annotation.Nullable;

public interface ShareBlogController
		extends ContactSelectorController<SelectableContactItem> {

	void share(GroupId g, Collection<ContactId> contacts, @Nullable String text,
			ExceptionHandler<DbException> handler);

}
