package org.downtimecrew.terraform

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
