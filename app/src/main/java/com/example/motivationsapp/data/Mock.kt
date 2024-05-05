package com.example.motivationsapp.data

import com.example.motivationsapp.infra.MotivationConstants

data class Phrase(val str: String, val categoryId: Int, val lang: String) {}


class Mock private constructor() {

    companion object {

        private val infinite = MotivationConstants.FILTER.INFINITE
        private val happy = MotivationConstants.FILTER.HAPPY
        private val sun = MotivationConstants.FILTER.SUN

        private val pt = MotivationConstants.LANGUAGE.PORTUGUESE
        private val en = MotivationConstants.LANGUAGE.ENGLISH
        private val fr = MotivationConstants.LANGUAGE.FRENCH

        private val mListPhrases = listOf<Phrase>(
            Phrase("Não sabendo que era impossível, foi lá e fez.", happy, pt),
            Phrase(
                "Você não é derrotado quando perde, você é derrotado quando desiste!",
                happy,
                pt
            ),
            Phrase("Quando está mais escuro, vemos mais estrelas!", happy, pt),
            Phrase(
                "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
                happy,
                pt
            ),
            Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy, pt),
            Phrase(
                "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
                happy,
                pt
            ),
            Phrase("A melhor maneira de prever o futuro é inventá-lo.", sun, pt),
            Phrase("Você perde todas as chances que você não aproveita.", sun, pt),
            Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sun, pt),
            Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sun, pt),
            Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sun, pt),
            Phrase("Se você acredita, faz toda a diferença.", sun, pt),
            Phrase(
                "Riscos devem ser corridos, porque o maior perigo é não arriscar nada!",
                sun,
                pt
            ),
            Phrase("Not knowing it was impossible, he went there and did it.", happy, en),
            Phrase(
                "You are not defeated when you lose, you are defeated when you give up!",
                happy,
                en
            ),
            Phrase("When it's darker, we see more stars!", happy, en),
            Phrase(
                "Insanity is always doing the same thing and expecting a different result.",
                happy,
                en
            ),
            Phrase("Don't stop when you're tired, stop when you're done.", happy, en),
            Phrase("What can you do now that has the biggest impact on your success?", happy, en),
            Phrase("The best way to predict the future is to invent it.", sun, en),
            Phrase("You lose every chance you don't take.", sun, en),
            Phrase("Failure is the spice that flavors success.", sun, en),
            Phrase(" As long as we are not committed, there will be hesitation!", sun, en),
            Phrase("If you don't know where you want to go, any way will do.", sun, en),
            Phrase("If you believe, it makes all the difference.", sun, en),
            Phrase(
                "Risks must be taken, because the greatest danger is not risking anything!",
                sun,
                en
            ),
            Phrase("Ne sachant pas que c'était impossible, il y est allé et l'a fait.", happy, fr),
            Phrase(
                "Tu n'es pas vaincu quand tu perds, tu es vaincu quand tu abandonnes!",
                happy,
                fr
            ),
            Phrase("Quand il fait plus sombre, on voit plus d'étoiles!", happy, fr),
            Phrase(
                "La folie, c'est toujours faire la même chose et s'attendre à un résultat différent.",
                happy,
                fr
            ),
            Phrase("Ne t'arrête pas quand tu es fatigué, arrête quand tu as fini.", happy, fr),
            Phrase(
                "Que pouvez-vous faire maintenant qui a le plus grand impact sur votre succès?",
                happy,
                fr
            ),
            Phrase("La meilleure façon de prédire l'avenir est de l'inventer.", sun, fr),
            Phrase("Vous perdez toutes les chances que vous ne prenez pas.", sun, fr),
            Phrase("L'échec est l'épice qui parfume le succès.", sun, fr),
            Phrase("Tant qu'on n'est pas engagé, il y aura des hésitations!", sun, fr),
            Phrase(
                "Si vous ne savez pas où vous voulez aller, n'importe quoi fera l'affaire.",
                sun,
                fr
            ),
            Phrase("Si vous croyez, cela fait toute la différence.", sun, fr),
            Phrase(
                "Il faut prendre des risques, car le plus grand danger est de ne rien risquer!",
                sun,
                fr
            )
        )

        fun handlePhrase(selectedId: Int, lang: String): String {

            if (selectedId == infinite) {
                return mListPhrases.filter { it.lang == lang }.random().str
            } else {
                val filtredPhrases =
                    mListPhrases.filter { it.categoryId == selectedId && it.lang == lang }
                return filtredPhrases.random().str
            }

        }

    }


}


