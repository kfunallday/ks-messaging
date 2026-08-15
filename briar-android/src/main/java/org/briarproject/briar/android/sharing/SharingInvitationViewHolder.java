package com.ksmessaging.android.sharing;

import android.view.View;

import org.briarproject.bramble.api.contact.Contact;
import org.briarproject.bramble.util.StringUtils;
import com.ksmessaging.R;
import com.ksmessaging.android.sharing.InvitationAdapter.InvitationClickListener;
import com.ksmessaging.api.sharing.SharingInvitationItem;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Nullable;

import static com.ksmessaging.android.util.UiUtils.getContactDisplayName;

class SharingInvitationViewHolder
		extends InvitationViewHolder<SharingInvitationItem> {

	SharingInvitationViewHolder(View v) {
		super(v);
	}

	@Override
	public void onBind(@Nullable SharingInvitationItem item,
			InvitationClickListener<SharingInvitationItem> listener) {
		super.onBind(item, listener);
		if (item == null) return;

		Collection<String> names = new ArrayList<>();
		for (Contact c : item.getNewSharers())
			names.add(getContactDisplayName(c));
		sharedBy.setText(
				sharedBy.getContext().getString(R.string.shared_by_format,
						StringUtils.join(names, ", ")));
	}

}
