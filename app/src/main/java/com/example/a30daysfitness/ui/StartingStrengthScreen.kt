package com.example.a30daysfitness.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysfitness.R
import com.example.a30daysfitness.model.FitnessUiState
import com.example.a30daysfitness.ui.components.ExerciseItem
import com.example.a30daysfitness.ui.theme.FitnessViewModel
import com.example.a30daysfitness.ui.theme._30DaysFitnessTheme


/**
 * A composable function that consists of a lazycolumn to display
 * everything in a scrollable fashion
 */
@Composable
fun StartingStrengthLazyList(
    uiState: FitnessUiState,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        item {
            Text(
                text = stringResource(id = R.string.program1),
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = R.string.programdesc1),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = stringResource(id = R.string.phase1),
                style = MaterialTheme.typography.displayMedium
            )
        }
        item {
            Text(
                text = stringResource(id = R.string.dayA),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 8.dp)
            )

        }
        items(
            items = uiState.currentProgram1A,
            ){excercise ->
            val saveExer = remember{
                excercise
            }
            ExerciseItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }


        item {
            Text(
                text = stringResource(id = R.string.dayB),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 8.dp)
            )

        }
        items(uiState.currentProgram1B){excercise ->
            val saveExer = remember{
                excercise
            }
            ExerciseItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }
        item {
            Text(
                text = stringResource(id = R.string.phase2),
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                text = stringResource(id = R.string.dayA),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        items(uiState.currentProgram2A){excercise ->
            val saveExer = remember{
                excercise
            }
            ExerciseItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }

        item {
            Text(
                text = stringResource(id = R.string.dayB),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 8.dp)
            )

        }
        items(uiState.currentProgram2B){excercise ->
            val saveExer = remember {
                excercise
            }
            ExerciseItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }

        item {
            Text(
                text = stringResource(id = R.string.phase3),
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                text = stringResource(id = R.string.dayA),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        items(uiState.currentProgram3A){excercise ->
            val saveExer = remember{
                excercise
            }
            ExerciseItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }

        item {
            Text(
                text = stringResource(id = R.string.dayB),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 8.dp)
            )

        }
        items(uiState.currentProgram3B){excercise ->
            val saveExer = remember{
                excercise
            }
            ExerciseItem(
                excercise = saveExer,
                modifier = modifier.padding(8.dp)
            )
        }
    }
}



@Preview
@Composable
private fun StartingPreview() {
    _30DaysFitnessTheme {
        StartingStrengthLazyList(
            uiState = FitnessUiState(),
        )
    }
}
