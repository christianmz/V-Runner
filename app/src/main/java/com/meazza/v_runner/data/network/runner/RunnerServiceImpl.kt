package com.meazza.v_runner.data.network.runner

import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.meazza.v_runner.data.model.Runner
import javax.inject.Inject

class RunnerServiceImpl @Inject constructor(
    mAuth: FirebaseAuth,
    db: FirebaseFirestore,
    storage: FirebaseStorage
) : RunnerService {

    override suspend fun createRunner(runner: Runner) {
        TODO("Not yet implemented")
    }

    override suspend fun getRunner(runnerId: String): Runner {
        TODO("Not yet implemented")
    }

    override suspend fun uploadRunnerPhoto(photo: Uri) {
        TODO("Not yet implemented")
    }

    override suspend fun updateRunnerInfo(runner: Runner) {
        TODO("Not yet implemented")
    }
}