package org.downtimecrew.terraform

class terraformValidate {
    def call(String Directory) {
        stage("Terraform validate") {
            script {
                sh """
                    cd ${Directory}
                    terraform validate
                """
            }
        }
    }
}
