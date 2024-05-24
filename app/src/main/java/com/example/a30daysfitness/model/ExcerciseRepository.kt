package com.example.a30daysfitness.model

import com.example.a30daysfitness.FitnessScreen
import com.example.a30daysfitness.R
import com.example.a30daysfitness.ui.theme.FitnessViewModel

object ExcerciseRepository {
    val programs = listOf(
        Programs(
            nameRes = R.string.program1,
            descriptionRes = R.string.program1desc,
            imageRes = R.drawable.starting_strength,
            setup = FitnessScreen.Starting
        ),
        Programs(
            nameRes = R.string.program2,
            descriptionRes = R.string.program2desc,
            imageRes = R.drawable.judo_begin,
            setup = FitnessScreen.Judo
        ),
        Programs(
            nameRes = R.string.program3,
            descriptionRes = R.string.program3desc,
            imageRes = R.drawable._day,
            setup = FitnessScreen.ThreeDay
        )
    )
    val excercises = listOf(
        Excercises(
            nameRes = R.string.squat,
            descriptionRes = R.string.squatdesc,
            imageRes = R.drawable._2560px_squats_svg,
            reps = 5,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.bench,
            descriptionRes = R.string.benchdesc,
            imageRes = R.drawable.bench_press_1_svg,
            reps = 5,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.deadlift,
            descriptionRes = R.string.deadliftdesc,
            imageRes = R.drawable._1200px_rear_deltoid_row_barbell_1_svg,
            reps = 5,
            sets = 1
        ),
        Excercises(
            nameRes = R.string.shoulderp,
            descriptionRes = R.string.shoulderpdesc,
            imageRes = R.drawable._4580253_200,
            reps = 5,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.clean,
            descriptionRes = R.string.cleandesc,
            imageRes = R.drawable._2227543,
            reps = 3,
            sets = 5
        ),

        Excercises(
            nameRes = R.string.deadclean,
            descriptionRes = R.string.deadcleandesc,
            imageRes = R.drawable._2227543,
            reps = 5,
            sets= 1
        ),
        Excercises(
            nameRes = R.string.chinup,
            descriptionRes = R.string.chinupdesc,
            imageRes = R.drawable.download,
            reps = 0,
            sets = 0
        ),
        Excercises(
            nameRes = R.string.dowelhinge,
            descriptionRes = R.string.dowelhingedesc,
            imageRes = R.drawable.dowel_hip_hinge,
            reps = 4,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.deadliftjump,
            descriptionRes = R.string.deadliftjumpdesc,
            imageRes = R.drawable._1200px_rear_deltoid_row_barbell_1_svg,
            reps = 4,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.lungeRow,
            descriptionRes = R.string.lungeRowDesc,
            imageRes = R.drawable.lungerow,
            reps = 5,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.deepsquatrow,
            descriptionRes = R.string.deepsquatrowdesc,
            imageRes = R.drawable.midcablerowsquat,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.zombiesquat,
            descriptionRes = R.string.zombiesquatdesc,
            imageRes = R.drawable.zombiesquat,
            reps = 6,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.armpulltowaist,
            descriptionRes = R.string.armpulltowaistdesc,
            imageRes = R.drawable.hingebackpulldown,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.shoulderpfromknee,
            descriptionRes = R.string.shoulderpfromkneedesc,
            imageRes = R.drawable.full_kneeling_dumbbell_overhead_press,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.inclinebench,
            descriptionRes = R.string.inclinebenchdesc,
            imageRes = R.drawable.incline_dumbell,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.cablecross,
            descriptionRes = R.string.cablecrossdesc,
            imageRes = R.drawable.cable_crossover,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.latraise,
            descriptionRes = R.string.latraisedesc,
            imageRes = R.drawable.dumbbell_lateral_raise_resized,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.skullcrush,
            descriptionRes = R.string.skullcrushdesc,
            imageRes = R.drawable.barbell_skull_crusher_resized,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.triceppushdown,
            descriptionRes = R.string.triceppushdowndesc,
            imageRes = R.drawable.triceps_rope_pushdown_resized,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.cablerow,
            descriptionRes = R.string.cablerowdesc,
            imageRes = R.drawable.seated_cable_row_new_resized,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.latpull,
            descriptionRes = R.string.latpulldesc,
            imageRes = R.drawable.wide_grip_lat_pull_down_resized,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.bentfly,
            descriptionRes = R.string.bentflydesc,
            imageRes = R.drawable.bent_over_fly,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.hyperextension,
            descriptionRes = R.string.hyperextensiondesc,
            imageRes = R.drawable._5_degree_hyperextension,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.bicepcurl,
            descriptionRes = R.string.bicepcurldesc,
            imageRes = R.drawable.barbell_curl_resized,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.hammercurl,
            descriptionRes = R.string.hammercurldesc,
            imageRes = R.drawable.hammer_curl,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.legpress,
            descriptionRes = R.string.legpressdesc,
            imageRes = R.drawable.sled_45_degree_leg_press_resized,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.legextension,
            descriptionRes = R.string.legextension,
            imageRes = R.drawable.lever_leg_extension_resized,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.legcurl,
            descriptionRes = R.string.legcurldesc,
            imageRes = R.drawable.seated_leg_curl,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.calfraises,
            descriptionRes = R.string.calfraisesdesc,
            imageRes = R.drawable.lever_standing_calf_raise_resized,
            reps = 8,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.plank,
            descriptionRes = R.string.plankdesc,
            imageRes = R.drawable.plank,
            reps = 30,
            sets = 3
        ),
        Excercises(
            nameRes = R.string.crunches,
            descriptionRes = R.string.crunchesdesc,
            imageRes = R.drawable.crunches,
            reps = 15,
            sets = 3
        )
    )
}