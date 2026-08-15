package com.ksmessaging.android.privategroup.invitation;

import android.content.Context;

import com.ksmessaging.R;
import com.ksmessaging.android.activity.ActivityComponent;
import com.ksmessaging.android.sharing.InvitationActivity;
import com.ksmessaging.android.sharing.InvitationAdapter;
import com.ksmessaging.api.privategroup.invitation.GroupInvitationItem;
import org.briarproject.nullsafety.MethodsNotNullByDefault;
import org.briarproject.nullsafety.ParametersNotNullByDefault;

import javax.inject.Inject;

import static com.ksmessaging.android.sharing.InvitationAdapter.InvitationClickListener;

@MethodsNotNullByDefault
@ParametersNotNullByDefault
public class GroupInvitationActivity
		extends InvitationActivity<GroupInvitationItem> {

	@Inject
	protected GroupInvitationController controller;

	@Override
	public void injectActivity(ActivityComponent component) {
		component.inject(this);
	}

	@Override
	protected GroupInvitationController getController() {
		return controller;
	}

	@Override
	protected InvitationAdapter<GroupInvitationItem, ?> getAdapter(Context ctx,
			InvitationClickListener<GroupInvitationItem> listener) {
		return new GroupInvitationAdapter(ctx, listener);
	}

	@Override
	protected int getAcceptRes() {
		return R.string.groups_invitations_joined;
	}

	@Override
	protected int getDeclineRes() {
		return R.string.groups_invitations_declined;
	}

}
