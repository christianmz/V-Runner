package com.meazza.v_runner.data.network.runs

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.storage.FirebaseStorage
import com.meazza.v_runner.common.Constants.AVERAGE_SPEED
import com.meazza.v_runner.common.Constants.CALORIES_BURNED
import com.meazza.v_runner.common.Constants.DISTANCE
import com.meazza.v_runner.common.Constants.IMAGE_URL
import com.meazza.v_runner.common.Constants.RUNNING_TIME
import com.meazza.v_runner.common.Constants.RUNS_REF
import com.meazza.v_runner.common.Constants.RUN_ID
import com.meazza.v_runner.common.Constants.TIMESTAMP
import com.meazza.v_runner.data.model.Run
import com.meazza.v_runner.util.convertToByteArray
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


@ExperimentalCoroutinesApi
class RunsServiceImpl @Inject constructor(
    mAuth: FirebaseAuth,
    db: FirebaseFirestore,
    storage: FirebaseStorage
) : RunsService {

    private val uid = mAuth.currentUser?.uid
    private val runRef = db.collection(RUNS_REF).document(uid!!).collection(RUNS_REF)
    private val storageRef = storage.reference

    override suspend fun insertRun(run: Run) {
        runRef.add(run).addOnSuccessListener { documentRef ->

            val runId = documentRef.id
            val bytes = run.image?.convertToByteArray()

            bytes?.let { image ->
                storageRef.child("$RUNS_REF/$uid/$runId").putBytes(image)
                    .addOnSuccessListener {
                        it.storage.downloadUrl.addOnSuccessListener { uri ->
                            runRef.document(runId).update(
                                IMAGE_URL, uri.toString(),
                                RUN_ID, runId
                            )
                        }
                    }
            }
        }.await()
    }

    override suspend fun deleteRun(run: Run) {
        runRef.document(run.runId).delete()
    }

    override suspend fun getRunsByDate(): Flow<List<Run>> = callbackFlow {
        val subscription = runRef.orderBy(TIMESTAMP, Query.Direction.DESCENDING)
            .addSnapshotListener { querySnapshot, _ ->
                querySnapshot?.let {
                    val runs = it.toObjects(Run::class.java)
                    offer(runs)
                }
            }
        awaitClose { subscription.remove() }
    }

    override suspend fun getRunsByDistance(): Flow<List<Run>> = callbackFlow {
        val subscription = runRef.orderBy(DISTANCE, Query.Direction.DESCENDING)
            .addSnapshotListener { querySnapshot, _ ->
                querySnapshot?.let {
                    val runs = it.toObjects(Run::class.java)
                    offer(runs)
                }
            }
        awaitClose { subscription.remove() }
    }

    override suspend fun getRunsByRunningTime(): Flow<List<Run>> = callbackFlow {
        val subscription = runRef.orderBy(RUNNING_TIME, Query.Direction.DESCENDING)
            .addSnapshotListener { querySnapshot, _ ->
                querySnapshot?.let {
                    val runs = it.toObjects(Run::class.java)
                    offer(runs)
                }
            }
        awaitClose { subscription.remove() }
    }

    override suspend fun getRunsByAverageSpeed(): Flow<List<Run>> = callbackFlow {
        val subscription = runRef.orderBy(AVERAGE_SPEED, Query.Direction.DESCENDING)
            .addSnapshotListener { querySnapshot, _ ->
                querySnapshot?.let {
                    val runs = it.toObjects(Run::class.java)
                    offer(runs)
                }
            }
        awaitClose { subscription.remove() }
    }

    override suspend fun getRunsByCaloriesBurned(): Flow<List<Run>> = callbackFlow {
        val subscription = runRef.orderBy(CALORIES_BURNED, Query.Direction.DESCENDING)
            .addSnapshotListener { querySnapshot, _ ->
                querySnapshot?.let {
                    val runs = it.toObjects(Run::class.java)
                    offer(runs)
                }
            }
        awaitClose { subscription.remove() }
    }
}