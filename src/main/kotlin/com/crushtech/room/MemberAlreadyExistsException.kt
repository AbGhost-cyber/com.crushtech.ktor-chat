package com.crushtech.room

class MemberAlreadyExistsException : Exception(
    "there is already a member with that username in the room"
)