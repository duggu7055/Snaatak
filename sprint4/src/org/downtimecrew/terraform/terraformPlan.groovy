package org.downtimecrew.terraform

class terraformPlan {
    def call(String Directory) {
        stage("Terraform plan") {
            script {
                sh """
                    cd ${Directory}
                    terraform plan
                """
            }
        }
    }
}
