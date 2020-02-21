pragma solidity >=0.4.22 <0.7.0;

import "./Family.sol";

contract Families {
    mapping(address => Family) families;
    event print(string indexed name);

    function createFamily(string memory _name) public {
        Family current = families[msg.sender];
        require(address(current) == address(0), "Already part of a family");

        Family newFamily = new Family(_name, msg.sender);
        families[msg.sender] = newFamily;
    }

    function joinFamily(address _toJoin) public {
        Family current = families[msg.sender];
        require(address(current) == address(0), "Already part of a family");

        Family fam = Family(_toJoin);

        families[msg.sender] = fam;
    }

    function myFamily() public view returns (Family) {
        address sender = msg.sender;
        return families[sender];
    }
}