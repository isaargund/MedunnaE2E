@apiroomcreatevalidation
  Feature: CreatedRoom_ApiValidation

    Scenario: Get all rooms
      Given Admin sends Get request for all rooms
      Then verify the  room is created