package org.downtimecrew.terraform

class terraformFmt {
    def call(String Directory) {
        stage("Terraform Fmt") {
            script {
                sh """
                    cd ${Directory}
                    terraform fmt
                """
            }
        }
    }
}
