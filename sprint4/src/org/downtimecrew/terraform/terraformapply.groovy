package org.downtimecrew.terraform

class terraformapply {
    def call(String Directory) {
        stage("Terraform Action") {
            script {
                def actionChoice = input(
                    message: "Which Terraform action would you like to perform?",
                    parameters: [
                        choice(name: "ACTION", choices: ["apply", "destroy", "skip"], description: "Choose the Terraform action")
                    ]
                )

                if (actionChoice == "skip") {
                    echo "Terraform action skipped by the user."
                    return
                }

                def userApproval = input(
                    message: "Do you want to proceed with Terraform ${actionChoice}?",
                    parameters: [
                        choice(name: "CONFIRM", choices: ["Yes", "No"], description: "Confirm your action")
                    ]
                )

                if (userApproval == "Yes") {
                    sh """
                        cd ${Directory}
                        terraform ${actionChoice} -auto-approve
                    """
                } else {
                    echo "Terraform ${actionChoice} was skipped by the user."
                }
            }
        }
    }
}
