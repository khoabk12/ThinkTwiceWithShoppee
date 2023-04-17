package com.devindie.stopusingshoppee.ui.screens.main

import com.devindie.stopusingshoppee.ui.screens.base.BaseViewModel

/**
 * Main view model
 * MainViewModel using for [MainFragment]
 *
 */
class MainViewModel : BaseViewModel() {
    /**
     * Has these parameters:
     * 1. turnOffCountPerDay [Int] : Store times user try to switch off on a day
     * 2. moneySpent: [Double]: The money user input want to spent
     * 3. salaryPerMonth: [Double]: The money user input their salary
     * 4. currentServiceState: [Boolean] Current toggle button
     *
     * UI Controller
     * 4. isShowButtonPlayGame: [Boolean] UI controller to check if button Play game need to show
     * 5. isWinning: [Boolean] UI result of user playing game
     * 6. isShownPlayingGameScreen: [Boolean] UI whether show screen play game
     */

    /**
     * Show dialog
     *
     * type of dialog need to be shown
     */

    fun showFlowTurnOffBy(turnOffCountPerDay: Int) {
        //Based on variable turnOffCountPerDay to show
        /**
         * if [turnOffCountPerDay] = 1
         *      show dialog how money they spent and how their salary => Give advice to them with 2 option "Close" and "Continue"
         * if [turnOffCountPerDay] = 2
         *      show dialog [giveAdviceStandUpAndGetDrinking]
         * if [turnOffCountPerDay] = 3
         *      show button Ac
         */
    }

    private fun calculateHourPerSpending(spending: Float): Float {
        //calculate how much hour do they have to work in order to spent that money
        return 0F
    }

    /**
     * Give advice that user need to return on xx hour based on [calculateHourPerSpending] has return
     */
    private fun giveAdviceReturnAppAt(hour: Float): String {
        return ""
    }

    /**
     * Give advice stand up and get drinking
     *
     * @return the message to remind user stand up and get drinking
     */
    private fun giveAdviceStandUpAndGetDrinking(): String {
        return ""
    }

    /**
     * Show prompt remind if items is really needed
     */
    private fun showPromptRemindIfItemsIsReallyNeeded() {
        /**
         * Show dialog to remind user if their items in carts is really needed or they just buy on sales?
         * Show two button: "Standing up => Drink a cup of water then decide later", "I actually really need it because I can't live without it"
         * Show toast: "Wish you have a wise time shopping"
         */
    }

    /**
     * UI press button play
     *
     */
    fun play() {

    }

    /**
     * Result game
     *
     * @param isWining
     */
    fun resultGame(isWining: Boolean) {

    }


    fun showPromptAskIfTheyLessStress() {
        /**
         * Show prompt ask if they less stress
         * ask them if they less stress now
         */
    }

    fun donate() {
        /**
         * Check if Momo is install => open deeplink MOMO with xx vnd
         */
    }
}