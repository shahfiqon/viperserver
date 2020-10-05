// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.
//
// Copyright (c) 2011-2020 ETH Zurich.

package viper.server

import spray.json._

object ViperRequests extends akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport with DefaultJsonProtocol {

  // Legacy verification request format.
  // TODO: use JSon for submitting verification requests.
  case class VerificationRequest(arg: String)
  implicit val VerificationRequest_format: RootJsonFormat[VerificationRequest] = jsonFormat1(VerificationRequest.apply)

  case class CacheResetRequest(backend: String, file: String)
  implicit val CacheResetRequest_format: RootJsonFormat[CacheResetRequest] = jsonFormat2(CacheResetRequest.apply)

  // Other requests go below this line.
  case class AlloyGenerationRequest(arg: String, solver: String)

  implicit val generateStuff = jsonFormat2(AlloyGenerationRequest.apply)
}
