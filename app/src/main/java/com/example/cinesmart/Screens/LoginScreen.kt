package com.example.cinesmart.Screens

import android.text.style.UnderlineSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinesmart.Components.ButtonBottomBar
import com.example.cinesmart.Components.NormalTextField
import com.example.cinesmart.R
import com.example.cinesmart.ui.theme.LocalAppColor
import com.example.cinesmart.ui.theme.LocalAppImage
import com.example.cinesmart.ui.theme.LocalAppPadding
import com.example.cinesmart.ui.theme.LocalAppTypography


@Composable
fun LoginScreen() {
    val email = rememberSaveable {
        mutableStateOf("")
    }
    val userName = rememberSaveable {
        mutableStateOf("")
    }
    val password = rememberSaveable {
        mutableStateOf("")
    }
    val retypePassword = rememberSaveable {
        mutableStateOf("")
    }
    Image(
        painter = painterResource(LocalAppImage.current.normal_theme),
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize()
            .blur(50.dp)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalAppColor.current.backgroundColorDarkBody.copy(alpha = .7f)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.padding(top = LocalAppPadding.current.top_app_padding.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painterResource(id = R.drawable.product_logo), contentDescription = "")
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = (LocalAppPadding.current.rounded_app_padding / 2).dp)
            ) {
                Text(
                    text = "CINE",
                    style = LocalAppTypography.current.text_24_bold,
                    color = LocalAppColor.current.textBonusColorLight,
                    modifier = Modifier.blur(1.dp)
                )
                Text(
                    text = "SMART",
                    style = LocalAppTypography.current.text_24_bold,
                    color = LocalAppColor.current.textColorOrange,
                    modifier = Modifier.blur(1.dp)
                )
            }
        }
        Text(
            text = "Sign in to your account",
            style = LocalAppTypography.current.text_24_bold,
            color = LocalAppColor.current.textColorLight,
            modifier = Modifier.padding(
                LocalAppPadding.current.rounded_app_padding.dp
            )
        )
        NormalTextField(value = email.value, label = "Email", leadingIcon = Icons.Rounded.Email) {it->
            email.value = it
        }
        NormalTextField(value = password.value, label = "Password", leadingIcon = Icons.Rounded.Lock, isLast = true) {it->
            password.value = it
        }
        ButtonBottomBar(
            content = "Login",
            modifier = Modifier.padding((2*LocalAppPadding.current.rounded_app_padding).dp),
            isNormal = false
        )
        Text(
            text = "Haven't had an account? Let create.",
            style = LocalAppTypography.current.text_16_bold,
            color = LocalAppColor.current.textBonusColorLight,
            modifier = Modifier.padding(LocalAppPadding.current.rounded_app_padding.dp).clickable {  }
        )
        ButtonBottomBar(
            content = "Register",
            modifier = Modifier.padding((2*LocalAppPadding.current.rounded_app_padding).dp),
            isNormal = true
        )
    }
}

@Preview
@Composable
fun PreviewLoginScreenComponents() {
    LoginScreen()
}