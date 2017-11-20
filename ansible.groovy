folder('Playbook')
pipelineJob('Pipeline/DSL_Pipeline') {

  def repo = 'https://github.com/mc1985/ansible-configuration.git'
  description("Pipeline for $repo")

  definition {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          branches('master',)
          scriptPath('Jenkinsfile')
          extensions { }  // required as otherwise it may try to tag the repo, which you may not want
        }

      }
    }
  }
}
