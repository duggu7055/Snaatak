package org.downtimecrew.terraform

class terraformInit {
    def call(String Directory) {
        stage("Terraform init") {
            script {
                sh """
                    cd ${Directory}
                    terraform init -reconfigure
                """
            }
        }
    }
}
