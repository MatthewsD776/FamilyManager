pragma solidity >=0.4.22 <0.7.0;

contract Family {
    string public familyName;
    int public memberCount = 5;
    address[] familyadmins;

    constructor(string memory _name, address _creator) public{
        familyName = _name;
        familyadmins.push(_creator);
    }
}