package com.ksmessaging.android.privategroup.invitation;

import android.view.View;

import com.ksmessaging.R;
import com.ksmessaging.android.sharing.InvitationAdapter.InvitationClickListener;
import com.ksmessaging.android.sharing.InvitationViewHolder;
import com.ksmessaging.api.privategroup.invitation.GroupInvitationItem;

import javax.annotation.Nullable;

import static com.ksmessaging.android.util.UiUtils.getContactDisplayName;

class GroupInvitationViewHolder
		extends InvitationViewHolder<GroupInvitationItem> {

	GroupInvitationViewHolder(View v) {
		super(v);
	}

	@Override
	public void onBind(@Nullable GroupInvitationItem item,
			InvitationClickListener<GroupInvitationItem> listener) {
		super.onBind(item, listener);
		if (item == null) return;

		sharedBy.setText(
				sharedBy.getContext().getString(R.string.groups_created_by,
						getContactDisplayName(item.getCreator())));
	}

}