package com.example.a30daysfitness.ui.theme

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import com.example.a30daysfitness.R
import com.example.a30daysfitness.model.ExcerciseRepository.excercises
import com.example.a30daysfitness.model.ExcerciseRepository.programs
import com.example.a30daysfitness.model.Excercises
import com.example.a30daysfitness.model.FitnessUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FitnessViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(FitnessUiState())
    val uiState: StateFlow<FitnessUiState> = _uiState.asStateFlow()


    fun setupScreens(@StringRes route: Int){
        if(route.equals(R.string.program1)){
            setupStarting()
        } else if(route.equals(R.string.program2)){
            setupJudo()
        } else{
            setupThreeDay()
        }
    }

   private fun setupStarting(){
        _uiState.update { fitnessUiState ->
            fitnessUiState.copy(
                currentProgram1A = make_workout_lis(excercises, 0,1,2),
                currentProgram1B = make_workout_lis(excercises, 0,3,2),
                currentProgram2A = make_workout_lis(excercises, 0,1,2),
                currentProgram2B = make_workout_lis(excercises, 0,3,4),
                currentProgram3A = make_workout_lis(excercises, 0,1,5),
                currentProgram3B = make_workout_lis(excercises,0,3,6)
            )
        }
    }
   private fun setupJudo(){
        _uiState.update { fitnessUiState ->
            fitnessUiState.copy(
                currentProgram1A = make_workout_lis(excercises,7,8,9),
                currentProgram2A = make_workout_lis(excercises, 2,10,1),
                currentProgram3A = make_workout_lis(excercises, 11, 0, 12,13)
            )
        }
    }
   private fun setupThreeDay(){
        _uiState.update{fitnessUiState ->
            fitnessUiState.copy(
                currentProgram1A = make_workout_lis(excercises,1,14,15,3,16,17,18),
                currentProgram2A = make_workout_lis(excercises,19,20,21,22,23,24),
                currentProgram3A = make_workout_lis(excercises,0,25,26,27,28,29)
            )
        }
    }

    private fun make_workout_lis(program: List<Excercises>,vararg index: Int): List<Excercises>{
        val lis = mutableListOf<Excercises>()
        for (i in index){
            lis.add(program[i])
        }
        return lis
    }
}