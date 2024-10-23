package org.sopt.and.presentation.ui.my

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.ui.theme.ANDANDROIDTheme
import org.sopt.and.ui.theme.Gray100
import org.sopt.and.ui.theme.Gray300
import org.sopt.and.ui.theme.GrayBlack
import org.sopt.and.ui.theme.White

@Composable
fun MyScreen(
    modifier: Modifier = Modifier,
    userName: String
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(GrayBlack)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Gray300)
                .padding(horizontal = 15.dp, vertical = 20.dp)
        ) {
            MyProfile(userEmail = userName)

            Spacer(modifier = Modifier.height(8.dp))

            MyPurchaseBox(information = stringResource(R.string.my_purchase_event))

            Spacer(modifier = Modifier.height(8.dp))

            MyPurchaseBox(information = stringResource(R.string.my_purchase_ticket))
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            MyListBox(
                title = stringResource(R.string.my_view_history),
                description = stringResource(R.string.my_view_history_none)
            )

            MyListBox(
                title = stringResource(R.string.my_interest_program),
                description = stringResource(R.string.my_interest_program_none)
            )
        }
    }
}

@Composable
fun MyProfile(userEmail: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_bnv_my_32),
            contentDescription = null,
            tint = White,
            modifier = Modifier.size(44.dp)
        )

        Text(
            text = stringResource(R.string.my_nickname, userEmail),
            modifier = Modifier
                .padding(start = 8.dp),
            color = White
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            painter = painterResource(R.drawable.ic_nofification_24),
            contentDescription = null,
            tint = White,
            modifier = Modifier
                .clickable { }
                .padding(8.dp)
        )

        Icon(
            painter = painterResource(R.drawable.ic_support_24),
            contentDescription = null,
            tint = White,
            modifier = Modifier
                .clickable { }
                .padding(8.dp)
        )
    }
}

@Composable
fun MyPurchaseBox(information: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = information,
            color = Gray100,
            fontSize = 16.sp
        )

        Row(
            modifier = Modifier
                .clickable { }
        ) {
            Text(
                text = stringResource(R.string.my_purchase),
                color = White,
                fontSize = 16.sp
            )

            Icon(
                painter = painterResource(R.drawable.ic_arrow_right_btn_24),
                contentDescription = null,
                tint = White
            )
        }
    }
}

@Composable
fun MyListBox(title: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 25.dp)
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            color = White
        )

        Icon(
            painter = painterResource(R.drawable.ic_block_44),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 30.dp),
            tint = Gray100
        )

        Text(
            text = description,
            fontSize = 16.sp,
            color = Gray100,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    ANDANDROIDTheme {
        MyScreen(userName = "jieundaeun@naver.com")
    }
}
