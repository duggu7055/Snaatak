package org.downtimecrew.terraform

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
