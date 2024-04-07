package com.example.tiktaktoeincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiktaktoeincompose.Won
import com.example.tiktaktoeincompose.ui.theme.TikTakToeInComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TikTakToeInComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colorResource(id = R.color.darkBlue01)),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Board()
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun Board(
    modifier: Modifier = Modifier


) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.darkBlue01)),
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Tic-Tac-Toe",
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold,
            color = Color.White, modifier = modifier.padding(40.dp)
        )
        UserArea()
        PlayingBoard0(modifier)
    }

}

fun checkWining(arr: Array<IntArray>): Boolean {
    // Check rows and columns
    for (i in 0 until 3) {
        if (arr[i][0] != 0 && arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
            return true
        }
        if (arr[0][i] != 0 && arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
            return true
        }
    }
    // Check diagonals
    if (arr[0][0] != 0 && arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) {
        return true
    }
    if (arr[2][0] != 0 && arr[2][0] == arr[1][1] && arr[1][1] == arr[0][2]) {
        return true
    }
    return false
}

@Composable
fun PlayingBoard0(modifier: Modifier = Modifier) {
    val arr = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0)
    )

    var currentPlayer by remember {
        mutableStateOf("1")
    }

    var winner by remember {
        mutableStateOf("")
    }

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(colorResource(id = R.color.darkBlue02))
    ) {
        Column {
            if (winner.isEmpty()) {
                if (checkWining(arr)) {
                    currentPlayer = if (currentPlayer == "1") "2" else "1"
                    winner = currentPlayer
                }
                Row {
                    Cell(user = currentPlayer, i = 0, j = 0, arr = arr) {
                        if (checkWining(arr)) {
                            winner = currentPlayer
                        } else {
                            currentPlayer = if (currentPlayer == "1") "2" else "1"
                        }
                    }
                    Cell(user = currentPlayer, i = 0, j = 1, arr = arr) {
                        if (checkWining(arr)) {
                            winner = currentPlayer
                        } else {
                            currentPlayer = if (currentPlayer == "1") "2" else "1"
                        }
                    }
                    Cell(user = currentPlayer, i = 0, j = 2, arr = arr) {
                        if (checkWining(arr)) {
                            winner = currentPlayer
                        } else {
                            currentPlayer = if (currentPlayer == "1") "2" else "1"
                        }
                    }
                }
                Row {
                    Cell(user = currentPlayer, i = 1, j = 0, arr = arr) {
                        if (checkWining(arr)) {
                            winner = currentPlayer
                        } else {
                            currentPlayer = if (currentPlayer == "1") "2" else "1"
                        }
                    }
                    Cell(user = currentPlayer, i = 1, j = 1, arr = arr) {
                        if (checkWining(arr)) {
                            winner = currentPlayer
                        } else {
                            currentPlayer = if (currentPlayer == "1") "2" else "1"
                        }
                    }
                    Cell(user = currentPlayer, i = 1, j = 2, arr = arr) {
                        if (checkWining(arr)) {
                            winner = currentPlayer
                        } else {
                            currentPlayer = if (currentPlayer == "1") "2" else "1"
                        }
                    }
                }
                Row {
                    Cell(user = currentPlayer, i = 2, j = 0, arr = arr) {
                        if (checkWining(arr)) {
                            winner = currentPlayer
                        } else {
                            currentPlayer = if (currentPlayer == "1") "2" else "1"
                        }
                    }
                    Cell(user = currentPlayer, i = 2, j = 1, arr = arr) {
                        if (checkWining(arr)) {
                            winner = currentPlayer
                        } else {
                            currentPlayer = if (currentPlayer == "1") "2" else "1"
                        }
                    }
                    Cell(user = currentPlayer, i = 2, j = 2, arr = arr) {
                        if (checkWining(arr)) {
                            winner = currentPlayer
                        } else {
                            currentPlayer = if (currentPlayer == "1") "2" else "1"
                        }
                    }
                }
            } else {
//                winner = if (winner == "1"){ "2"} else{ "1"}
                Won(winner)
            }
        }
    }
}


@Preview
@Composable
fun Won(player: String = "JP") {
    Card(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(), colors = CardDefaults.cardColors(Color.DarkGray)
    ) {
        Text(
            text = "$player has won the match.",
            modifier = Modifier.padding(20.dp),
            fontSize = 40.sp,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.LightGray
        )

    }
}


@Composable
fun Cell(
    modifier: Modifier = Modifier,
    bg: Int = R.color.darkBlue01,
    user: String = "",
    i: Int,
    j: Int,
    arr: Array<IntArray>,
    onClick: () -> Unit
) {
    var tx by remember {
        mutableStateOf("")
    }
    Box(
        modifier = modifier
            .clickable {
                onClick()
                tx = user
                arr[i][j] = user.toInt()
            }
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(colorResource(id = bg))
            .size(100.dp)
            .border(
                2.dp, Color.DarkGray, RoundedCornerShape(10.dp),

                )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            Text(text = tx, color = Color.LightGray, fontSize = 30.sp)
        }
    }
}


@Composable
fun UserArea(modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(20.dp)) {
        UserCard(modifier, "X", 1)
        UserCard(modifier, "O", 2)
    }
}

@Composable
fun UserCard(modifier: Modifier = Modifier, user: String = "X", userNo: Int = 1) {
    Card(
        modifier = modifier.padding(10.dp),
        colors = CardDefaults.cardColors(colorResource(id = R.color.darkBlue02))
    ) {
        Column {

            Text(
                text = " $user \n $userNo",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                color = Color.White, modifier = modifier.padding(20.dp, 40.dp)
            )
        }
    }
}



