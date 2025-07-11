def call(Map config = [:]) {
    def wsClean     = new org.downtimecrew.common.cleanWorkspace()
    def gitCheckOut = new org.downtimecrew.common.checkout()
    def fmt         = new org.downtimecrew.terraform.terraformFmt()
    def init        = new org.downtimecrew.terraform.terraformInit()
    def validate    = new org.downtimecrew.terraform.terraformValidate()
    def plan        = new org.downtimecrew.terraform.terraformPlan()
    def apply       = new org.downtimecrew.terraform.terraformapply()
    def destroy     = new org.downtimecrew.terraform.terraformdestroy()

    try {
        wsClean.call()
        gitCheckOut.call([
            branch  : config.gitBranch,
            repoUrl : config.gitRepoUrl,
            creds   : config.gitCredsId
        ])

        init.run(config)
        fmt.run(config)
        validate.run(config)
        plan.run(config)

        if (config.action == 'apply') {
            apply.call([
                envDir     : config.terraformDir,
                awsCredsId : config.awsCredId
            ], this)
        }

        if (config.action == 'destroy') {
            destroy.call([
                envDir     : config.terraformDir,
                awsCredsId : config.awsCredId
            ], this)
        }

    } catch (Exception e) {
        throw e
    }
}
