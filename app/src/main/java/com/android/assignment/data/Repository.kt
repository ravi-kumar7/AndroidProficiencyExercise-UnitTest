package com.android.assignment.data

import com.android.assignment.R
import com.android.assignment.data.model.Fact
import javax.inject.Inject

class Repository @Inject constructor() {

    fun getData(): ArrayList<Fact> {
        val data = ArrayList<Fact>()
        data.add(
            Fact(
                "Beavers",
                "Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony",
                R.drawable.american_beaver
            )
        )
        data.add(
            Fact(
                "Flag", "", R.drawable.flag_of_canada
            )
        )
        data.add(
            Fact(
                "Transportation",
                "It is a well known fact that polar bears are the main mode of transportation in Canada. They consume far less gas and have the added benefit of being difficult to steal.",
                R.drawable.the_golden_compass_still
            )
        )
        data.add(
            Fact(
                "Housing",
                "Warmer than you might think.",
                R.drawable.igloo_icon
            )
        )
        data.add(
            Fact(
                "Public Shame",
                "Sadly it's true.",
                R.drawable.avril_lavigne
            )
        )
        data.add(
            Fact(
                "Kittens...",
                "Éare illegal. Cats are fine.",
                R.drawable.cat
            )
        )
        data.add(
            Fact(
                "Mounties",
                "They are the law. They are also Canada's foreign espionage service. Subtle.",
                R.drawable.guy
            )
        )
        return data
    }
}